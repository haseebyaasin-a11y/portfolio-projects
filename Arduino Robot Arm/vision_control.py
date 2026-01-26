import torch
import cv2
import time
from robot_arm import base, shoulder, elbow, gripper

print("Loading YOLO model...")
model = torch.hub.load('WongKinYiu/yolov7', 'custom', 'yolov7.pt')
print("YOLO model loaded.")

def pickup_object():
    print("YOLO: Starting object search...")

    cap = cv2.VideoCapture(1)

    FRAME_CENTER_X = 640 // 2
    TOLERANCE = 80

    base_angle = 90
    base(base_angle)

    while True:
        ret, frame = cap.read()
        if not ret:
            continue

        results = model(frame)
        detections = results.xyxy[0]

        if len(detections) > 0:
            x1, y1, x2, y2, conf, cls = detections[0].tolist()
            x_center = int((x1 + x2) / 2)

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
