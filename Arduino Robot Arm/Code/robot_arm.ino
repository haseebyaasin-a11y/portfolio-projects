#include <Servo.h>

Servo baseServo;
Servo shoulderServo;
Servo elbowServo;
Servo wristServo;
Servo gripperServo;

String command = "";

void setup() {
  Serial.begin(9600);

  baseServo.attach(3);
  shoulderServo.attach(5);
  elbowServo.attach(6);
  wristServo.attach(9);     // wrist servo
  gripperServo.attach(10);

  baseServo.write(90);
  shoulderServo.write(90);
  elbowServo.write(90);
  wristServo.write(90);
  gripperServo.write(90);
}

void loop() {
  while (Serial.available()) {
    char c = Serial.read();

    if (c == '\n') {
      processCommand(command);
      command = "";
    } else {
      command += c;
    }
  }
}

void processCommand(String cmd) {
  cmd.trim();

  int colonIndex = cmd.indexOf(':');
  if (colonIndex == -1) return;

  String servoName = cmd.substring(0, colonIndex);
  int angle = cmd.substring(colonIndex + 1).toInt();
  angle = constrain(angle, 0, 180);

  if (servoName == "base") baseServo.write(angle);
  else if (servoName == "shoulder") shoulderServo.write(angle);
  else if (servoName == "elbow") elbowServo.write(angle);
  else if (servoName == "wrist") wristServo.write(angle);
  else if (servoName == "gripper") gripperServo.write(angle);
}
