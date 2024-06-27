package dev.cb.boxoffice;

import dev.cb.boxoffice.model.*;
import dev.cb.boxoffice.persistence.*;
import dev.cb.boxoffice.presentation.AddressMenu;
import dev.cb.boxoffice.presentation.Ihm;
import dev.cb.boxoffice.presentation.MainMenu;
import dev.cb.boxoffice.presentation.Menu;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        AddressRepository addressRepository = new AddressRepository(PostgresEntityManager.getEntityManager());
        ClientRepository clientRepository = new ClientRepository(PostgresEntityManager.getEntityManager());
        EventRepository eventRepository = new EventRepository(PostgresEntityManager.getEntityManager());
        TicketRepository ticketRepository = new TicketRepository(PostgresEntityManager.getEntityManager());

        Map<Integer, Menu> menus = new HashMap<>();
        Menu mainMenu = new MainMenu();
        menus.put(0, mainMenu);
        Menu addressMenu = new AddressMenu();
        menus.put(1, addressMenu);

        Ihm.menus = menus;
        Ihm.actualMenu = menus.get(0);
        Ihm.run();

        Address address = new Address("1 rue du OK", "Montreux");
//        addressRepository.save(address);
//        Optional<Client> clientOptional = clientRepository.findById(1);
//        clientOptional.ifPresentOrElse(System.out::println, () -> System.out.println("Client not found"));
//        System.out.println(addressRepository.findAll());
//        addressRepository.update(address);
//        addressRepository.delete(address);

        Client client = new Client("boulbi", "oskour", LocalDate.now(), "1123456789", address);
//        clientRepository.save(client);
//        Optional<Client> clientOptional = clientRepository.findById(2);
//        clientOptional.ifPresentOrElse(System.out::println, () -> System.out.println("Client not found"));
//        System.out.println(clientRepository.findAll());
//        clientRepository.update(client);
//        clientRepository.delete(client);

        Event event = new Event("tourcoing plage", LocalDateTime.now(), 300, address);
//        eventRepository.save(event);
//        Optional<Event> eventOptional = eventRepository.findById(2);
//        eventOptional.ifPresentOrElse(System.out::println, () -> System.out.println("Event not found"));
//        System.out.println(eventRepository.findAll());
//        eventRepository.update(event);
//        eventRepository.delete(event);

        Ticket ticket = new Ticket(1,10, TypePlace.STANDARD, client, event);
//        ticketRepository.save(ticket);
//        Optional<Ticket> ticketOptional = ticketRepository.findById(1);
//        ticketOptional.ifPresentOrElse(System.out::println, () -> System.out.println("Ticket not found"));
//        System.out.println(ticketRepository.findAll());
//        ticketRepository.update(ticket);
//        ticketRepository.delete(ticket);
    }
}
