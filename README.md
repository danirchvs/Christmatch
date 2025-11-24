<h1 align = "center"> 🤍🌿 ＣＨＲＩＳＴＭＡＴＣＨ ☕🎶</h1>
<p align = "center">
  <img src="https://img.shields.io/badge/Language-Java-red" alt="Language Java">
  <img src="https://img.shields.io/badge/License-MIT-green" alt="License MIT">
<h3 align = "center">A console-based match game.</h3>
<p align = "center">
<b>CS 2104 - Group 5</b>
</p>
<p align = "center">
    Aningalan, Jared Lance S. <br/>
    Balilla, Danielle A. <br/>
    Castillano, Rex Anthony C.
</p>
</p>
<br/>
<br/>
<br/>

# ✩‧₊˚ ┊🎄Overview

Christmatch is a console-based, Christmas-themed memory matching game. Players flip cards on a 2x4 grid to find the four lost Christmas spirits: Love, Peace, Warmth, and Joy.

This project was built to showcase the four fundamental Object-Oriented Programming (OOP) principles: encapsulation, inheritance, polymorphism, and abstraction.

The game features a dynamic narrative, playful hints on mismatches, and a fully scripted ending. Completing all matches restores the Christmas spirits and concludes with a joyful, celebratory story, letting players enjoy both the memory challenge and the heartwarming tale of Everpine.<br/>
<br/>
<br/>

# ✩‧₊˚ ┊🎮Game Features
```
🎴 Memory Match Gameplay: Flip two cards at a time on a 2x4 game board to find matching pairs.
    
🌟 Narrative Story: Save the town of Everpine by finding the four lost Christmas spirits: Love, Peace, Warmth, and Joy.
    
❤️ Dynamic Event System: Every successful match triggers a unique, story-driven "Match Event" to advance the plot.
    
💥 Chaos Events: Failed matches trigger a fun, random "Mismatch Chaos Event" with a descriptive (and chaotic!) message.
    
⌨️ Robust Input Handling: Strong validation prevents the game from crashing due to non-numeric text, out-of-bounds numbers, or selecting the same card twice.
    
⏳ Dramatic Pauses: Timed pauses in the story text create a more cinematic and immersive narrative experience.
    
☃️ Scripted Ending: A festive, text-based ending sequence plays once all spirits are found and the game is won.
```
<br/>
<br/>
<br/>



# ✩‧₊˚ ┊📂Project Structure


This project is built as a **single-file application**. All the code, logic, and class definitions are contained within the main `EverpineChristmas.java` file.

* **`EverpineChristmas`** (The main class): The program's entry point; runs the menu and handles user input.

Below is a diagram-like structure of the other primary helper classes defined inside the file:

```
├── Card
├── MemoryBoard
├── Utils
└── Event (abstract class)
    │
    ├── Match Events (subclasses)
    │   │   (For handling successful matches)
    │   │
    │   ├── JoyEvent
    │   ├── LoveEvent
    │   ├── PeaceEvent
    │   └── WarmthEvent
    │
    └── Mismatch Chaos Events (subclasses)
        │   (For handling failed matches)
        │
        ├── BellGiftChaosEvent
        ├── BellSnowmanChaosEvent
        ├── BellTreeChaosEvent
        ├── GiftBellChaosEvent
        ├── GiftSnowmanChaosEvent
        ├── GiftTreeChaosEvent
        ├── SnowmanBellChaosEvent
        ├── SnowmanGiftChaosEvent
        ├── SnowmanTreeChaosEvent
        ├── TreeBellChaosEvent
        ├── TreeGiftChaosEvent
        └── TreeSnowmanChaosEvent
```

**Class Descriptions:**

* **`Card`**: Represents a single card, holding its value and whether it's flipped.
* **`MemoryBoard`**: The **core game engine** that manages the board, game logic, and card matching.
* **`Utils`**: A helper class for repeating functions, like clearing the screen.
* **`Event`**: The base "template" for all game events, divided into the two types shown above.
<br/>
<br/>
<br/>



# ✩‧₊˚ ┊🚀 How to Run the Program


Ready to play? Here's how to launch the game from your computer's terminal.

1.  **Open Your Terminal**
    * Start your favorite command line terminal (like Command Prompt, PowerShell, or Windows Terminal). You'll see a prompt, usually starting with your user folder:
    ```
    C:\Users\YourName>
    ```

2.  **Navigate to the Game Folder**
    * Use the `cd` (Change Directory) command to move into the folder where you saved the game. For this example, let's assume it's `C:\EverpineChristmas`.
    ```
    C:\Users\YourName>cd C:\EverpineChristmas
    ```

3.  **Fix the ❔❔ (Enable Emoji Support)**
    * To make all the game's special characters 🎄 and borders show up correctly (instead of `?`), you need to set your terminal to the right "code page."
    * Run this magic command:
    ```
    C:\EverpineChristmas>chcp 65001
    ```
    * Your terminal will confirm the change:
    ```
    Active code page: 65001
    ```

4.  **Launch the Game!**
    * You're all set! Just type `java` followed by the program's name to start your adventure.
    ```
    C:\EverpineChristmas>java EverpineChristmas
    ```

...The game will now load. Good luck, and have fun!
<br/>
<br/>
<br/>

# ‧₊˚ ┊🍵Object-Oriented Principles

**💊 Encapsulation** <br/>
        Encapsulation was applied by making class fields `private`. For example, in the **`Card`** class, the `symbol` and `matched` variables are private. They can only be accessed or modified through public methods like `getSymbol()` and `setMatched()`. This protects the card's state from being changed incorrectly from outside the class.

💡 **Abstraction**<br/>
        Abstraction was implemented using the **`abstract class Event`**. The main `EverpineChristmas` class doesn't need to know the *specifics* of what a `LoveEvent` or a `TreeGiftChaosEvent` does. It just knows it has arrays of `Event` objects and can call the `event.trigger()` method on any of them. This hides the complex details of each event behind a simple, common interface.

🧬 **Inheritance**<br/>
        Inheritance is the core of the event system. All 16 event classes (from `LoveEvent` to `BellSnowmanChaosEvent`) **`extend`** the abstract `Event` class. They inherit the "Event" type and are required to provide their own implementation for the `trigger()` method. This allows us to treat all events as the same "type" while they all have unique behaviors.

🎭 **Polymorphism**<br/>
        Polymorphism is demonstrated when the `trigger()` method is called. In the `main` loop, the *same line of code* (`matchEvents[joyLevel].trigger()` or `mismatchEvents[...].trigger()`) can result in **many different behaviors** at runtime. Depending on the object, it might print a "Love Event" message or a "Chaos Event" message. This ability for the same code to execute different behaviors is polymorphism.
<br/>
<br/>
<br/>


# ‧₊˚ ┊🎉Example Output
```
🎄========================================🎄
        THE LOST CHRISTMAS OF EVERPINE
🎄========================================🎄
In the frozen town of Everpine, the mischievous Frost Sprite has stolen
the four great spirits of Christmas: Love, Peace, Warmth, and Joy.
Only by matching the lost pairs can you restore the light of the season...

GUIDE:
• The board has 2 rows (0–1) and 4 columns (0–3).
• On each turn, select TWO cards to flip.
• Enter them as FOUR numbers:  r1 c1 r2 c2
  Example: 0 1 1 3

 ⚠️ If you type letters, too few numbers, or numbers out of range,
   the game will warn you instead of crashing.


??      ??      ??      ??
??      ??      ??      ??

Choose two cards (r1 c1 r2 c2):
```
<br/>
<br/>
<br/>

# ‧₊˚ ┊⭐Contributors
<table>
<tr>
    <th> &nbsp; </th>
    <th> Name </th>
    <th> Role </th>
</tr>
<tr>
    <td><img src="https://avatars.githubusercontent.com/u/191443793?v=4" width="100" height="100"> </td>
    <td><strong>Jared Lance S. Aningalan</strong> <br/>
    <a href="https://github.com/JaredAningalan" target="_blank">
    <img src="https://img.shields.io/badge/GitHub-%23121011.svg?logo=github&logoColor=green" alt="githubnijared">
        </a>
    </td>
    <td>Contributor</td>
</tr>
<tr>
    <td><img src="https://avatars.githubusercontent.com/u/191433397?v=4" width="100" height="100"> </td>
    <td><strong>Danielle A. Balilla</strong> <br/>
    <a href="https://github.com/danirchvs" target="_blank">
    <img src="https://img.shields.io/badge/GitHub-%23121011.svg?logo=github&logoColor=pink" alt="githubnidani">
        </a>
    </td>
    <td>Contributor</td>
</tr>
<tr>
    <td><img src="https://avatars.githubusercontent.com/u/183066995?v=4" width="100" height="100"> </td>
    <td><strong>Rex Anthony C. Castillano</strong> <br/>
    <a href="https://github.com/rexanthonyyy" target="_blank">
    <img src="https://img.shields.io/badge/GitHub-%23121011.svg?logo=github&logoColor=blue" alt="githubnirex">
       </a>
    </td>
    <td>Contributor</td>
</tr>
</table>
<br/>
<br/>
<br/>

#  ‧₊˚ ┊ 😍Acknowledgment
We would like to express our sincere gratitude to **Mr. Emmanuel Charlie Enriquez** and **Ms. Fatima Marie P. Agdon**, for their invaluable guidance and constructive feedback throughout the project. We also extend our appreciation to our classmates and peers for their insightful suggestions and collaborative spirit, which greatly contributed to the development process.
