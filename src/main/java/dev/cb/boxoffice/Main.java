package dev.cb.boxoffice;

import dev.cb.boxoffice.model.Address;
import dev.cb.boxoffice.persistence.AddressRepository;
import dev.cb.boxoffice.persistence.PostgresEntityManager;

public class Main {

    public static void main(String[] args) {

        AddressRepository addressRepository = new AddressRepository(PostgresEntityManager.getEntityManager());

        Address address = new Address("4 rue du Test", "Tourcoing");

//        addressRepository.save(address);

        System.out.println(addressRepository.findById(1));;
        System.out.println(addressRepository.findAll());;
    }
}
