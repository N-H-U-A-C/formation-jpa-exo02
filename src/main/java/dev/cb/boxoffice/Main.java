package dev.cb.boxoffice;

import dev.cb.boxoffice.model.Address;
import dev.cb.boxoffice.model.Client;
import dev.cb.boxoffice.model.Event;
import dev.cb.boxoffice.persistence.AddressRepository;
import dev.cb.boxoffice.persistence.ClientRepository;
import dev.cb.boxoffice.persistence.EventRepository;
import dev.cb.boxoffice.persistence.PostgresEntityManager;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        AddressRepository addressRepository = new AddressRepository(PostgresEntityManager.getEntityManager());
        ClientRepository clientRepository = new ClientRepository(PostgresEntityManager.getEntityManager());
        EventRepository eventRepository = new EventRepository(PostgresEntityManager.getEntityManager());

        Address address = new Address("1 rue du OK", "Montreux");
//        addressRepository.save(address);
//        Optional<Client> clientOptional = clientRepository.findById(1);
//        clientOptional.ifPresentOrElse(System.out::println, () -> System.out.println("Client not found"));
//        System.out.println(addressRepository.findAll());
//        addressRepository.update(address);
//        addressRepository.delete(address);

        Client client = new Client(3, "paco", "rabanne", LocalDate.now(), "1123456789", address);
//        clientRepository.save(client);
//        Optional<Client> clientOptional = clientRepository.findById(2);
//        clientOptional.ifPresentOrElse(System.out::println, () -> System.out.println("Client not found"));
//        System.out.println(clientRepository.findAll());
//        clientRepository.update(client);
//        clientRepository.delete(client);

        Event event = new Event(2,"montreux jazz festival", LocalDateTime.now(), 300, address);
//        eventRepository.save(event);
//        Optional<Event> eventOptional = eventRepository.findById(2);
//        eventOptional.ifPresentOrElse(System.out::println, () -> System.out.println("Event not found"));
//        System.out.println(eventRepository.findAll());
//        eventRepository.update(event);
//        eventRepository.delete(event);

    }

}
