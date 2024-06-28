package dev.cb.boxoffice.presentation;

import java.util.Map;

public abstract class Menu {

    protected Map<Integer, Runnable> actions;
    protected String entityClassName;
    protected String menuText;
    protected String inputText;
    protected String inText;
    protected String outText;

    public Menu() {
        this.inputText = "\nPlease enter\s";
    }

    protected void changeActualMenu(int key) {
        Ihm.actualMenu = Ihm.menus.get(key);
    }

    protected void displayMenu() {
        System.out.println(menuText);
    }

    protected void displayInputText(String inputLabel) {
        System.out.print(this.inputText + inputLabel + ":\s");
    }

    protected void displayInputText(String fieldClass, String fieldLabel) {
        System.out.print(this.inputText + fieldClass + " " + fieldLabel + ":\s");
    }

    public Map<Integer, Runnable> getActions() {
        return actions;
    }
}
