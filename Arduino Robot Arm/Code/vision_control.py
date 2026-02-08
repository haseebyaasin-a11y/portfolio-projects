import cv2
import numpy as np
import onnxruntime as ort
import time
from robot_arm import base, shoulder, elbow, wrist, gripper

print("Loading YOLO model...")

# Load ONNX model
session = ort.InferenceSession("yolov5s.onnx")
input_name = session.get_inputs()[0].name

print("YOLO model loaded.")

def preprocess(frame):
    # Convert BGR → RGB
    img = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)

    # Resize to YOLOv5 expected size
    img = cv2.resize(img, (640, 640))

    # IMPORTANT: ONNX model expects float16
    img = img.astype(np.float16) / 255.0

    # Channels first
    img = img.transpose(2, 0, 1)

    # Add batch dimension
    img = np.expand_dims(img, axis=0)

    return img

def pickup_object():
    print("YOLO: Starting object search...")

    # Try Mac webcam first (avoid iPhone continuity camera)
    cap = cv2.VideoCapture(1)
    if not cap.isOpened():
        print("Camera 1 failed, trying camera 0...")
        cap = cv2.VideoCapture(0)

    if not cap.isOpened():
        print("ERROR: No camera available.")
        return

    FRAME_CENTER_X = 640 // 2
    TOLERANCE = 80

    base_angle = 90
    base(base_angle)
    wrist(90)

    while True:
        ret, frame = cap.read()
        if not ret:
            continue

        # Preprocess for ONNX
        img = preprocess(frame)

        # Run inference
        outputs = session.run(None, {input_name: img})
        detections = outputs[0][0]  # YOLOv5 output

        # If no detections, continue
        if detections is None or len(detections) == 0:
            cv2.imshow("YOLO Robot", frame)
            if cv2.waitKey(1) == ord('q'):
                break
            continue

        # Take only the first 6 values (YOLO always puts important ones first)
        x1, y1, x2, y2, conf, cls = detections[0][:6]

        # Compute center of detected object
        x_center = int((x1 + x2) / 2)

        # Rotate base to center object
        if x_center < FRAME_CENTER_X - TOLERANCE:
            base_angle -= 3
            base_angle = max(0, base_angle)
            base(base_angle)

        elif x_center > FRAME_CENTER_X + TOLERANCE:
            base_angle += 3
            base_angle = min(180, base_angle)
            base(base_angle)

        else:
            print("YOLO: Object centered. Moving to grab...")

            shoulder(120)
            time.sleep(1)

            elbow(140)
            time.sleep(1)

            gripper(0)
            time.sleep(1)

            gripper(180)
            time.sleep(1)

            shoulder(90)
            elbow(90)
            time.sleep(1)

            print("YOLO: Object picked up.")
            break

        cv2.imshow("YOLO Robot", frame)
        if cv2.waitKey(1) == ord('q'):
            break

    cap.release()
    cv2.destroyAllWindows()
    print("YOLO: Finished.")
