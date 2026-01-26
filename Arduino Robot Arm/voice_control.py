import pyaudio
import json
import serial
from vosk import Model, KaldiRecognizer

# ---------------------------------------------------------
# 1. Load Vosk offline speech model
# ---------------------------------------------------------
model = Model("model")
recognizer = KaldiRecognizer(model, 16000)
print("Voice control system loaded.")

# ---------------------------------------------------------
# 2. Connect to Arduino
# ---------------------------------------------------------
arduino = serial.Serial('/dev/tty.usbmodem1101', 9600)

# ---------------------------------------------------------
# 3. Microphone setup
# ---------------------------------------------------------
audio = pyaudio.PyAudio()
stream = audio.open(format=pyaudio.paInt16,
                    channels=1,
                    rate=16000,
                    input=True,
                    frames_per_buffer=8000)
stream.start_stream()

# ---------------------------------------------------------
# 4. Import YOLO pickup function
# ---------------------------------------------------------
from vision_control import pickup_object

# ---------------------------------------------------------
# 5. Wake/sleep state
# ---------------------------------------------------------
awake = False
print("Say 'wake up' to activate voice control.")

# ---------------------------------------------------------
# 6. Main loop
# ---------------------------------------------------------
while True:
    data = stream.read(4000, exception_on_overflow=False)

    if recognizer.AcceptWaveform(data):
        result = recognizer.Result()
        text = json.loads(result)["text"]
        print("Heard:", text)

        # Wake up
        if "wake up" in text or "robot" in text:
            awake = True
            print("Voice control activated.")
            continue

        # Sleep
        if "sleep" in text or "stop listening" in text:
            awake = False
            print("Voice control deactivated.")
            continue

        # Ignore commands if asleep
        if not awake:
            continue

        # ---------------------------------------------------------
        # 7. Voice commands
        # ---------------------------------------------------------

        # Trigger YOLO object pickup
        if "go" in text:
            print("Searching for object...")
            pickup_object()
            print("Done. Listening again.")
            continue

        # Basic servo commands
        if "open" in text:
            arduino.write(b"open\n")
        elif "close" in text:
            arduino.write(b"close\n")
        elif "left" in text:
            arduino.write(b"left\n")
        elif "right" in text:
            arduino.write(b"right\n")
        elif "up" in text:
            arduino.write(b"up\n")
        elif "down" in text:
            arduino.write(b"down\n")
