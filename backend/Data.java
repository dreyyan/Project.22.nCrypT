package backend;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class Data {
    static Scanner scanner = new Scanner(System.in);

    public static int getInt(String prompt, int startRange, int endRange) {
        int userChoice = -1;

        while (true) {
            Utility.delayedDisplay(prompt, 0.1);
            try {
                userChoice = scanner.nextInt();
                scanner.nextLine();

                if (!(userChoice >= startRange && userChoice <= endRange)) {
                    Utility.errorMessage("Invalid input, please enter a valid choice.");
                    System.out.print("\033[2K\033[F\033[2K");
                    continue;
                } return userChoice;
            } catch (InputMismatchException e) {
                scanner.nextLine();
                Utility.errorMessage("Invalid input, please enter a valid number.");
                System.out.print("\033[2K\033[F\033[2K");
            }
        }
    }
    
    public static String getString(String prompt) {
        String userChoice = "";

        while (true) {
            Utility.delayedDisplay(prompt, 0.1);
            userChoice = scanner.nextLine();

            if (!userChoice.isEmpty()) {
                return userChoice;
            } else {
                Utility.errorMessage("Input cannot be blank.");
                System.out.print("\033[2K\033[F\033[2K");
            }
        }
    }

    public static char getChar(String prompt) {
        String userChoice = "";

        while (true) {
            Utility.delayedDisplay(prompt, 0.1);
            userChoice = scanner.nextLine().trim();

            if (!userChoice.isEmpty()) {
                return userChoice.charAt(0);
            } else {
                Utility.errorMessage("Input cannot be blank.");
                System.out.print("\033[2K\033[F\033[2K");
            }
        }
    }

    public static String getRandomString(String cipherName) {
        Gson gson = new Gson();
        String path = "data/words.json";

        try (Reader reader = new FileReader(path)) {
            String[] words = gson.fromJson(reader, String[].class);

            if (words == null || words.length == 0) {
                throw new IllegalStateException("No words found in JSON for cipher: " + cipherName);
            }

            // Pick a random sentence or word
            String word = words[(int)(Math.random() * words.length)];

            return word;
        } catch (IOException e) {
            System.err.println("Could not read JSON file for cipher: " + path);
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            System.err.println("Invalid JSON format in file: " + path);
            e.printStackTrace();
        }

        return null;
    }

}
