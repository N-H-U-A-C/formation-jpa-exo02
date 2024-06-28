package dev.cb.boxoffice.presentation;

import dev.cb.boxoffice.model.Address;
import dev.cb.boxoffice.persistence.AddressRepository;

import java.util.HashMap;
import java.util.Optional;

public class AddressMenu extends Menu {

    private AddressRepository addressRepository;

    public AddressMenu(AddressRepository addressRepository) {
        super();
        this.addressRepository = addressRepository;
        this.actions = new HashMap<>();
        actions.put(1, () -> this.create());
        actions.put(2, () -> this.read());
        actions.put(3, () -> this.readAll());
        actions.put(4, () -> System.out.println("update"));
        actions.put(5, () -> System.out.println("delete"));
        actions.put(6, () -> this.changeActualMenu(0));
        actions.put(0, () -> Ihm.hasQuit = true);
        this.entityClassName = "Address";
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

    private void readAll() {
        System.out.println(addressRepository.findAll());
    }

    private void read() {
        int id = Integer.valueOf(Ihm.readInput(this.entityClassName.toLowerCase(), "id"));
        Optional<Address> optionalAddress = addressRepository.findById(id);
        optionalAddress.ifPresentOrElse(System.out::println, () -> System.out.println(this.entityClassName + " not found"));
    }

    private void create() {
        this.addressRepository.save(this.createAddress());
    }

    private Address createAddress() {
        Address address = new Address();
        address.setStreet(Ihm.readInput(this.entityClassName.toLowerCase(), "street"));
        address.setCity(Ihm.readInput(this.entityClassName.toLowerCase(), "city"));
        return address;
    }
}
