package dev.cb.boxoffice;

import dev.cb.boxoffice.model.Address;
import dev.cb.boxoffice.model.Client;
import dev.cb.boxoffice.persistence.AddressRepository;
import dev.cb.boxoffice.persistence.ClientRepository;
import dev.cb.boxoffice.persistence.PostgresEntityManager;

import java.time.LocalDate;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        AddressRepository addressRepository = new AddressRepository(PostgresEntityManager.getEntityManager());
        ClientRepository clientRepository = new ClientRepository(PostgresEntityManager.getEntityManager());

        Address address = new Address("5 rue du Test", "Lille");
//        addressRepository.save(address);
//        System.out.println(addressRepository.findById(1));
//        System.out.println(addressRepository.findAll());
//        addressRepository.update(address);
//        addressRepository.delete(address);

        Client client = new Client(3,"paco", "rabanne", LocalDate.now(), "1123456789", address);
//        clientRepository.save(client);
//        Optional<Client> clientOptional = clientRepository.findById(2);
//        clientOptional.ifPresentOrElse(System.out::println, () -> System.out.println("Client not found"));
//        System.out.println(clientRepository.findAll());
//        clientRepository.update(client);
//        clientRepository.delete(client);
    }
}
