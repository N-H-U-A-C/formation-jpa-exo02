package dev.cb.boxoffice.presentation;

import java.util.Map;

public abstract class Menu {

    protected Map<Integer, Runnable> actions;
    protected String menuText;
    protected String choiceText;
    protected String inputText;
    protected String inText;
    protected String outText;

    public Menu() {
        this.choiceText = """
                Please enter a choice:\s
                """;
        this.inText = """
                \nWelcome to the box office app!""";
        this.outText = """
                \nGoodbye!
                """;
    }

    protected void changeActualMenu(int key) {
        Ihm.actualMenu = Ihm.menus.get(key);
    }

    protected void displayMenu() {
        System.out.println(menuText);
    }

    protected void displayChoiceText() {
        System.out.println(choiceText);
    }

    protected void displayInText() {
        System.out.println(inText);
    }

    protected void displayOutText() {
        System.out.println(outText);
    }

    public Map<Integer, Runnable> getActions() {
        return actions;
    }
}
