package dev.cb.boxoffice;

import dev.cb.boxoffice.model.Address;
import dev.cb.boxoffice.persistence.AddressRepository;
import dev.cb.boxoffice.persistence.PostgresEntityManager;

public class Main {

    public static void main(String[] args) {

        AddressRepository addressRepository = new AddressRepository(PostgresEntityManager.getEntityManager());

        Address address = new Address(2,"5 rue du Test", "Lille");

//        addressRepository.save(address);
//        System.out.println(addressRepository.findById(1));
//        System.out.println(addressRepository.findAll());
//        addressRepository.update(address);
//        addressRepository.delete(address);
    }
}
