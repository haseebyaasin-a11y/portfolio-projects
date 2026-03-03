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
    img = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
    img = cv2.resize(img, (640, 640))
    img = img.astype(np.float16) / 255.0
    img = img.transpose(2, 0, 1)
    img = np.expand_dims(img, axis=0)
    return img

def pickup_object():
    print("YOLO: Starting continuous object scanning...")

    # Your external webcam is index 0
    cap = cv2.VideoCapture(0, cv2.CAP_AVFOUNDATION)

    if not cap.isOpened():
        print("ERROR: Camera 0 failed to open.")
        return

    FRAME_CENTER_X = 640 // 2
    TOLERANCE = 80

    # Home position
    HOME_BASE = 90
    base_angle = HOME_BASE
    base(base_angle)
    wrist(90)
    shoulder(90)
    elbow(90)

    while True:
        ret, frame = cap.read()
        if not ret:
            continue

        img = preprocess(frame)
        outputs = session.run(None, {input_name: img})
        detections = outputs[0][0]

        detections = [d for d in detections if d[4] > 0.40]

        # Draw all detections
        for det in detections:
            x1, y1, x2, y2, conf, cls = det[:6]
            cv2.rectangle(frame, (int(x1), int(y1)), (int(x2), int(y2)), (0, 255, 0), 2)
            label = f"{int(cls)} ({conf:.2f})"
            cv2.putText(frame, label, (int(x1), int(y1)-10),
                        cv2.FONT_HERSHEY_SIMPLEX, 0.6, (0,255,0), 2)

        if len(detections) == 0:
            cv2.imshow("YOLO Robot", frame)
            if cv2.waitKey(1) == ord('q'):
                break
            continue

        # Pick the closest object (largest area)
        closest = max(detections, key=lambda d: (d[2]-d[0]) * (d[3]-d[1]))
        x1, y1, x2, y2, conf, cls = closest[:6]

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

            # Move arm to grab
            shoulder(120)
            time.sleep(0.8)

            elbow(140)
            time.sleep(0.8)

            gripper(0)  # close
            time.sleep(0.8)

            print("YOLO: Object grabbed. Moving to drop zone...")

            # Rotate to far-left drop zone (base = 0°)
            base(0)
            time.sleep(1.2)

            # Drop object
            gripper(180)
            time.sleep(0.6)

            print("YOLO: Object dropped. Returning home...")

            # Return to home position
            base(HOME_BASE)
            shoulder(90)
            elbow(90)
            time.sleep(1)

            print("YOLO: Ready for next object.")

        cv2.imshow("YOLO Robot", frame)
        if cv2.waitKey(1) == ord('q'):
            break

    cap.release()
    cv2.destroyAllWindows()
    print("YOLO: Finished scanning.")
