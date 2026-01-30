## Vision Control
The robot arm uses a simple computer‑vision pipeline built with **OpenCV** to detect objects based on color thresholds and contour detection. The system processes each camera frame, identifies the target’s position, and sends movement commands to the Arduino over serial communication. This allows the arm to automatically track or move toward detected objects without manual input.

## Voice Control
Voice commands are processed using the Vosk offline speech‑recognition engine, which converts spoken instructions into text in real time without requiring an internet connection. Commands such as “open,” “close,” “left,” or “lift” are recognized by the model, mapped to predefined robot‑arm actions, and sent to the Arduino for execution. This enables hands‑free, natural voice control of the robotic arm using a lightweight and efficient speech‑recognition pipeline.## Arduino Code Overview
The Arduino code controls all servo movements for the robot arm and listens for commands sent from the vision and voice‑control systems. Each servo is assigned to a specific joint (base, shoulder, elbow, and gripper), and the code uses incremental angle updates to ensure smooth, non‑jerky motion.

Incoming commands are received over the serial connection. When the Arduino detects a command—such as “LEFT,” “OPEN,” “GRIP,” or a set of coordinates—it maps that instruction to a predefined movement routine. The code then adjusts the servo angles accordingly, moving the arm to the desired position.
