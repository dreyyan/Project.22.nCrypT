import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

import backend.*;
import backend.cipher.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    static Map<Integer, Class<? extends Cipher>> cipherList = new HashMap<>();

    static {
        // Substitution Ciphers
        cipherList.put(1, CaesarCipher.class);
/*         cipherList.put(2, Monoalphabetic.class);
        cipherList.put(3, AtbashCipher.class);
        cipherList.put(4, KeywordCipher.class);
        cipherList.put(5, PlayfairCipher.class);

        // Transposition Ciphers
        cipherList.put(6, RailFenceCipher.class);
        cipherList.put(7, ColumnarTransposition.class);
        cipherList.put(8, RouteCipher.class);

        // Polyalphabetic Ciphers
        cipherList.put(9, VigenereCipher.class);
        cipherList.put(10, BeaufortCipher.class);
        cipherList.put(11, AutokeyCipher.class);

        // Modern Ciphers
        cipherList.put(12, AESCipher.class);
        cipherList.put(13, RSACipher.class);
        cipherList.put(14, DESCipher.class);
        cipherList.put(15, BlowfishCipher.class) */;
    }

    public static void startGame() {
        Utility.delayedDisplayLn("* ~ * ~ [ Start Game ] ~ * ~ *", 0);
        Utility.displayFormat('=', 30);

        // prompt user to enter cipher of choice
        int counter = 1;

        for (Integer key: cipherList.keySet()) {
            if (counter < 10) {
                System.out.print(' ');
            }

            System.out.printf("[%d] %s", counter++, cipherList.get(key).getSimpleName());
            System.out.println();
        } Utility.displayFormat('=', 30);
        counter = 1; // reset counter
        
        int cipherChoice = Data.getInt("Cipher: ", 1, 5);
        String cipherName = cipherList.get(cipherChoice).getSimpleName();

        // prompt user to enter # of problems
        int problemCount = Data.getInt("# of Problems(Max: 5): ", 1, 5);

        // prompt user to enter type of problem
        String[] problemType = { "Decrypt", "Encrypt", "Mixed" };

        for (String type : problemType) {
            System.out.printf("[%d] %s\n", counter++, type);
        } Utility.displayFormat('=', 30);

        int problemTypeChoice = Data.getInt("Problem Type: ", 1, 3);

        // start of game logic
        int problemNumber = 1;
        int score = 0;
        
        while (true) {
            while (problemNumber <= problemCount) {
                String randomString = null;
                Cipher cipher = null;
                String answer, solution;

                try {
                    randomString = Data.getRandomString(cipherName);
                    cipher = cipherList.get(cipherChoice).getDeclaredConstructor().newInstance();
                    
                    Utility.clearScreen(10);
                    System.out.printf("[%s - Problem #%d]\n", cipherName, problemNumber++);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                if (cipher == null || randomString == null) {
                    System.err.println("Failed to initialize cipher or random string. Skipping this problem.");
                    continue;
                }

                int currentProblemType = problemTypeChoice;

                // if mixed, map to either 0 or 1 (decrypt/encrypt)
                if (problemTypeChoice == 3) {
                    int randomNumber = (int)Math.round(Math.random());
                    currentProblemType = (randomNumber == 1) ? 1 : 2;
                }

                if (currentProblemType == 1) {
                    // Decrypt
                    String encrypted = cipher.encrypt(randomString);
                    System.out.println("Encrypted: " + encrypted);
                    System.out.print("Answer: ");
                    answer = scanner.nextLine();
                    solution = randomString;
                } else {
                    // Encrypt
                    String decrypted = cipher.decrypt(randomString);
                    System.out.println("Decrypted: " + decrypted);
                    System.out.print("Answer: ");
                    answer = scanner.nextLine();
                    solution = randomString;
                }

                System.out.println("answer type: " + answer.getClass().getName());
                System.out.println("solution type: " + solution.getClass().getName());

                // check if answer is correct
                if (answer.trim().equalsIgnoreCase(solution.trim())) {
                    ++score;
                    System.out.println("Correct! (+1 point)");
                    Utility.delay(2);
                } else {
                    System.out.printf("Not quite... the answer is: %s\n", solution);
                    Utility.delay(2);
                }
            }

            // show evaluation
            Utility.clearScreen(10);
            Utility.delayedDisplayLn("* ~ * ~ [ Evaluation ] ~ * ~ *", 0);
            Utility.displayFormat('=', 30);
            System.out.printf("Total Score: %d/%d\n", score, problemCount);
            Utility.displayFormat('=', 30);

            // prompt user whether to play again
            System.out.print("Would you like to play again[y/n]?: ");
            char userChoice = Data.getChar("");

            if (userChoice == 'y') {
                problemNumber = 1;
                score = 0;
                continue;
            } else {
                break;
            }
        }
    }

    public static void displayAchievements() {
        Utility.delayedDisplayLn(" ~ * ~ [ Achievements ] ~ * ~ ", 0);
        Utility.displayFormat('=', 30);

    }

    public static void displayStatistics() {
        Utility.delayedDisplayLn("* ~ * ~ [ Statistics ] ~ * ~ *", 0);
        Utility.displayFormat('=', 30);
    }

    public static void main(String[] args) {
        int userChoice = 0;
        while (true) {
            Utility.clearScreen(10);
            Utility.delayedDisplayLn("~ * ~ * ~ [ nCrypT ] ~ * ~ * ~", 0.1);
            Utility.displayFormat('=', 30);
            Utility.delayedDisplayLn("[1] Start Game", 0.1);
            Utility.delayedDisplayLn("[2] Achievements", 0.1);
            Utility.delayedDisplayLn("[3] Statistics", 0.1);
            Utility.delayedDisplayLn("[4] Exit", 0.1);
            Utility.displayFormat('=', 30);

            userChoice = Data.getInt(">> ", 1, 4);

            Utility.clearScreen(10);

            switch (userChoice) {
                case 1:
                    startGame();
                    break;
                case 2:
                    displayAchievements();
                    break;
                case 3:
                    displayStatistics();
                    break;
                case 4:
                    Utility.delayedDisplay("exiting system...", 2);
                    System.exit(0);
                    break;
            }

            Utility.pressEnterToContinue();
        }
    }
}