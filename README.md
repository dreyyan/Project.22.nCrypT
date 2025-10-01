# nCrypT
_A Cryptic Cipher Game System via Java_

**nCrypT** is an engaging Java-based game that challenges players to solve cryptographic puzzles through a Text User Interface (TUI). Players decrypt ciphers, unlock secrets, and progress through levels of increasing complexity, blending entertainment with educational insights into cryptography. Utilizing the Gson library for JSON data handling, nCrypT offers a lightweight, interactive experience for puzzle enthusiasts and developers learning Java and cryptographic concepts.

The primary purpose of nCrypT is to provide a fun, brain-teasing game that teaches basic cryptography principles while showcasing Java programming for TUI-based applications and data management.

## FEATURES
✅ **Cipher Puzzles** – Solve a variety of cryptographic challenges to progress through the game.  
✅ **Interactive TUI** – Navigate puzzles and game menus via a user-friendly text interface.  
✅ **JSON Data Handling** – Store and manage game data (e.g., puzzles, progress) using Gson.  
✅ **Scalable Design** – Modular backend for easy addition of new ciphers and levels.  

## FUTURE IMPLEMENTATIONS
🚀 **Advanced Ciphers** – Introduce complex algorithms like AES or RSA for harder puzzles.  
🚀 **Progress Saving** – Implement persistent game state storage for seamless play.  
🚀 **Leaderboard System** – Track player scores and completion times.  
🚀 **Graphical Interface** – Transition to a GUI for enhanced user experience.  

## UPDATES
🔄 Initial TUI and core cipher-solving mechanics implemented.  
🔄 Gson integration for efficient data management.  
🔄 Ongoing development of puzzle variety and difficulty scaling.  

## PROJECT DETAILS
📌 **Author:** dreyyan  
📌 **Started:** 2025-07-31  
📌 **Finished:**  

## TECH STACK
🛠️ **Language:** Java  
🛠️ **Libraries:** Gson (for JSON handling), Standard Java libraries  

## INSTALLATION
### Prerequisites
- Java Development Kit (JDK) 8 or higher
- Gson library (version 2.13.1 or compatible)
- Create a development environment:
  - Install JDK from [Oracle](https://www.oracle.com/java/technologies/downloads/) or use OpenJDK.
  - Download `gson-2.13.1.jar` from [Maven Repository](https://mvnrepository.com/artifact/com.google.code.gson/gson/2.13.1).

### Install Dependencies
Place `gson-2.13.1.jar` in the project root or a `lib` directory.

### Compilation
Compile the source files:
```
javac -cp gson-2.13.1.jar -d out backend/*.java backend/cipher/*.java Main.java
```

### Run
Execute the compiled game:
```
java -cp "gson-2.13.1.jar;out" Main
```

### Verify Installation
Check Java version:
```
java -version
```
Ensure `gson-2.13.1.jar` is in the correct path and accessible.

## USAGE
### Running the Application
Compile and run as described above. The game launches in a terminal with a TUI.

### Example Workflow
1. **Launch the Game**: Run `java -cp "gson-2.13.1.jar;out" Main` to start the TUI.
2. **Navigate Menus**: Use keyboard inputs to select game modes or levels.
3. **Solve Puzzles**: Decrypt ciphers by entering solutions or following in-game prompts.
4. **Track Progress**: View scores or level completion (if implemented).

### Configuration
- Ensure `gson-2.13.1.jar` is in the project directory or adjust the classpath.
- No additional configuration is required; game settings are managed via the TUI.

## DEBUGGING
For issues, check console output for errors related to Gson parsing, file access, or cipher logic. Run with:
```
java -cp "gson-2.13.1.jar;out" Main
```
Report issues via GitHub Issues for detailed troubleshooting.

## PROJECT STRUCTURE
- `Main.java`: Entry point for the application.
- `backend/*.java`: Core game logic and utilities.
- `backend/cipher/*.java`: Cipher implementations and puzzle mechanics.

## CONTRIBUTING
Contributions are welcome! Fork the repo, make changes, and submit a pull request:
1. Create a feature branch: `git checkout -b feature/new-feature`
2. Commit changes: `git commit -m "Add new feature"`
3. Push: `git push origin feature/new-feature`
4. Open a pull request

Report issues or suggest features via GitHub Issues.

## LICENSE
This project is licensed under the MIT License. See [LICENSE](LICENSE) for details.