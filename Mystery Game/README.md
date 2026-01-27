## Murder on Estate Belladonna – Project Overview
This project is a multi‑frame Java Swing mystery game where the player takes on the role of a detective investigating the poisoning of Mistress Eleanore. The game blends storytelling, character interrogation, evidence review, and decision‑making into an interactive experience.

The application is built using Java Swing and structured across multiple frames:
- **Frame 1 – Introduction:** Presents the backstory, sets the tone, and loads background audio.
- **Frame 2 – Interrogation Board:** Allows the player to question suspects (Butler, Gardener, Maid, Lady Margaret).  
  - Each suspect has multiple dialogue options.  
  - A **slider** controls “interrogation intensity,” dynamically changing their responses.  
  - Character portraits and themed UI elements enhance immersion.
- **Frame 3 – Evidence Board:** Displays crime‑scene images, diary entries, and inheritance clauses.  
  - Clicking thumbnails opens enlarged images.  
  - A diary viewer allows navigation through multiple entries.  
  - Inheritance rules provide key motives for suspects.
- **Frame 4 – Decision Board:** The player selects the culprit from a dropdown list.  
  - The game tracks incorrect guesses.  
  - After two wrong attempts, the player is sent back to gather more evidence.  
  - On the third wrong guess, the game reveals the true culprit.  
  - Correct guesses show the murderer’s portrait and full explanation.

## Key Features
- Multi‑frame navigation using a shared `ApplicationData` manager  
- Dynamic dialogue based on interrogation intensity  
- Image scaling, thumbnails, and pop‑up dialogs  
- Integrated audio playback  
- Story‑driven logic with branching outcomes  
- Clean UI with custom colors, borders, and themed assets
## Skills Demonstrated

###  Design & Visual Presentation
A major focus of this project was creating a polished, atmospheric user interface. The game uses a custom color palette, themed character portraits, smooth image scaling, and carefully structured layouts to deliver a cohesive mystery‑themed experience.

###  Technical Development
This project showcases strong Java Swing development skills, including multi‑frame application structure, event‑driven programming, dynamic UI updates, and clean resource management.

###  Narrative & Game Logic
The game features branching dialogue, interrogation intensity mechanics, and a structured deduction system that guides the player through solving the mystery.

### Software Architecture
The application uses a modular, frame‑based design with shared state management through `ApplicationData`, separating UI, logic, and assets for maintainability.

### Multimedia Integration
The game incorporates audio playback, custom images, and interactive visual elements to create an immersive experience.

## How the Code Works (Short Summary)
- **Frame1** loads the intro screen, background image, and audio, then transitions to the interrogation board.  
- **Frame2** handles all suspect interactions. Each button triggers an `ActionListener` that checks the slider value and updates dialogue accordingly.  
- **Frame3** manages evidence: diary entries, inheritance clauses, and clickable crime‑scene images.  
- **Frame4** implements the guessing system, tracks incorrect attempts, and reveals the ending.  
- Shared data (frames, audio, incorrect guesses) is stored in `ApplicationData`.
## Future Improvements
- Improving overall design, and user experience on all frames
- Animated Transitions / Character Animations
- Save/Load System
- Hint System
- Inventory System 

