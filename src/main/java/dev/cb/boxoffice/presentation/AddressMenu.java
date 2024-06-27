package dev.cb.boxoffice.presentation;

import java.util.HashMap;

public class AddressMenu extends Menu {

    public AddressMenu() {
        super();
        this.actions = new HashMap<>();
        actions.put(1, () -> System.out.println("create"));
        actions.put(2, () -> System.out.println("read"));
        actions.put(3, () -> System.out.println("read all"));
        actions.put(4, () -> System.out.println("update"));
        actions.put(5, () -> System.out.println("delete"));
        actions.put(6, () -> this.changeActualMenu(0));
        actions.put(0, () -> Ihm.hasQuit = true);
        this.menuText = """
                \n=== Address Menu ===
                                
                1. Create an address
                2. Read an address by id
                3. Read all addresses
                4. Update an address
                5. Delete an address
                6. Return to main menu
                0. Exit
                """;
    }
}
