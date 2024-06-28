package dev.cb.boxoffice.presentation;

import java.util.Map;
import java.util.Scanner;

public class Ihm {

    public static final Scanner scanner;
    public static Map<Integer, Menu> menus;
    public static Menu actualMenu;
    public static String userInput;
    public static boolean hasQuit;

    static {
        scanner = new Scanner(System.in);
        hasQuit = false;
    }

    public static void run() {
        do {
            actualMenu.displayMenu();
            userInput = readInput("choice");
            actualMenu.getActions().get(Integer.valueOf(userInput)).run();
        } while (!hasQuit);
    }

    public static String readInput(String inputLabel) {
        actualMenu.displayInputText(inputLabel);
        return scanner.nextLine();
        //TODO input control
    }

    public static String readInput(String fieldClass,String fieldLabel) {
        actualMenu.displayInputText(fieldClass, fieldLabel);
        return scanner.nextLine();
        //TODO input control
    }
}
