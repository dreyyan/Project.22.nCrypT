package backend;

import java.util.Scanner;

public class Utility {
    static Scanner scanner = new Scanner(System.in);

    public static void delay(int delayS) {
        try {
            Thread.sleep((long)(delayS * 1000));
        } catch (InterruptedException e) {}
    }

    public static void errorMessage(String message) {
        System.out.printf("ERROR: %s", message);
        delay(2);
    }

    public static void clearScreen(int length) {
        for (int i = 0; i < length; ++i) {
            System.out.println("\033[H\033[2J");
        }
    } 

    public static void pressEnterToContinue() {
        System.out.print("Press [Enter] to continue...");
        scanner.nextLine();
    }

    public static void delayedDisplay(String str, double delayS) {
        System.out.print(str);
        try {
            Thread.sleep((long)(delayS * 1000));
        } catch (InterruptedException e) {
            errorMessage("delay interrupted");
        }
    }

    public static void delayedDisplayLn(String str, double delayS) {
        System.out.println(str);
        try {
            Thread.sleep((long)(delayS * 1000));
        } catch (InterruptedException e) {}
    }

    public static void displayFormat(char symbol, int length) {
        for (int i = 0; i < length; ++i) {
            System.out.print(symbol);
        } System.out.println();
    }
}
