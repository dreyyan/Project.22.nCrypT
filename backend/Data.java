package backend;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.google.gson.Gson;

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

    public static String getRandomString(String json) {
        Gson gson = new Gson();
        String[] words = gson.fromJson(json, String[].class);

        String sentence = Arrays.stream(words)
                                .map(String::toLowerCase)
                                .collect(Collectors.joining(" "));
        sentence = Character.toUpperCase(sentence.charAt(0)) + sentence.substring(1) + ".";

        System.out.println(sentence);  // Optional
        return words.toString();
    }
}
