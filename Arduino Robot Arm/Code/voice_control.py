import pyaudio
import json
import serial
from vosk import Model, KaldiRecognizer

model = Model("model")
recognizer = KaldiRecognizer(model, 16000)
print("Voice control system loaded.")

arduino = serial.Serial('/dev/tty.usbmodem1101', 9600)

audio = pyaudio.PyAudio()
stream = audio.open(format=pyaudio.paInt16,
                    channels=1,
                    rate=16000,
                    input=True,
                    frames_per_buffer=8000)
stream.start_stream()

from vision_control import pickup_object

awake = False
print("Say 'wake up' to activate voice control.")

while True:
    data = stream.read(4000, exception_on_overflow=False)

    if recognizer.AcceptWaveform(data):
        result = recognizer.Result()
        text = json.loads(result)["text"]
        print("Heard:", text)

        if "wake up" in text or "robot" in text:
            awake = True
            print("Voice control activated.")
            continue

        if "sleep" in text or "stop listening" in text:
            awake = False
            print("Voice control deactivated.")
            continue

        if not awake:
            continue

        if "go" in text:
            print("Searching for object...")
            pickup_object()
            print("Done. Listening again.")
            continue

        if "open" in text:
            arduino.write(b"gripper:180\n")
        elif "close" in text:
            arduino.write(b"gripper:0\n")
        elif "left" in text:
            arduino.write(b"base:60\n")
        elif "right" in text:
            arduino.write(b"base:120\n")
        elif "up" in text:
            arduino.write(b"shoulder:60\n")
        elif "down" in text:
            arduino.write(b"shoulder:120\n")
        elif "wrist up" in text:
            arduino.write(b"wrist:60\n")
        elif "wrist down" in text:
            arduino.write(b"wrist:120\n")
