# Arduino Robot Arm

A 4‑DOF Arduino‑powered robot arm designed for precise servo control, motion sequencing, and interactive demonstrations. Built using hobby servos, an Arduino Uno, and a custom control algorithm.

## Project Description
This robot arm project explores the fundamentals of robotics, servo actuation, and microcontroller programming. The arm is capable of performing basic movements such as gripping, lifting, rotating, and placing objects. It is programmed using Arduino Python and controlled through predefined motion sequences.

The project focuses on:
- Servo motor control
- Kinematic movement
- Mechanical design and stability
- Smooth motion sequencing
  
## Control Methods

### Vision Control
The robot arm includes a vision‑based control system that uses a camera feed to detect objects and guide the arm’s movements. The system identifies object position and sends corresponding commands to the Arduino, allowing the arm to automatically align, track, or move toward detected targets. This adds a layer of autonomy and demonstrates how computer vision can be integrated with physical robotics.

### Voice Control
The project also features voice‑activated control, allowing the user to operate the robot arm through spoken commands. Using a speech‑recognition interface, commands such as “open gripper,” “rotate left,” or “lift arm” are translated into serial instructions for the Arduino. This enables hands‑free operation and showcases the interaction between software and hardware.


## Features
- 4‑axis movement (base rotation, shoulder, elbow, gripper)
- Smooth servo motion using incremental angle control
- Pre‑programmed movement routines
- Manual calibration mode
- Expandable design for sensors or joystick control

## Hardware Used
- Arduino Uno
- MG90S servo motors
- External 5V power supply
- 3D‑printed arm structure
- Jumper wires and breadboard


## Code
All  code is located in the `code/` folder.

## Images
Photos of the robot arm can be found in the `images/` folder.

## Future Enhancements
- Joystick or potentiometer manual control
- Inverse kinematics for smoother, more accurate movement
- Bluetooth or WiFi remote control

