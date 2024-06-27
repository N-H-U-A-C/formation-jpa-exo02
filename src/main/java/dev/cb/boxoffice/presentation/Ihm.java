package dev.cb.boxoffice.presentation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ihm {

    public static final Scanner scanner;
    public static Map<Integer, Menu> menus;
    public static Menu actualMenu;
    public static int userChoice;
    public static boolean hasQuit;

    static {
        scanner = new Scanner(System.in);
        menus = new HashMap<>();
        hasQuit = false;
    }

    public static void run() {
        actualMenu.displayInText();
        do {
            actualMenu.displayMenu();
            makeChoice();
        } while (!hasQuit);
        actualMenu.displayOutText();
    }

    private static void makeChoice() {
        actualMenu.displayChoiceText();
        actualMenu.getActions().get(Integer.valueOf(scanner.nextLine())).run();
        //TODO input control
    }
}
