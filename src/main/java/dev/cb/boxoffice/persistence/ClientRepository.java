package dev.cb.boxoffice.persistence;


import dev.cb.boxoffice.model.Client;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class ClientRepository {

    private EntityManager em;

    public ClientRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Client client) {
        em.getTransaction().begin();
        em.persist(client);
        em.getTransaction().commit();
        System.out.println("Client saved: " + client);
    }

    public Optional<Client> findById(int id) {
        em.getTransaction().begin();
        Optional<Client> optionalClient = Optional.ofNullable(em.find(Client.class, id));
        em.getTransaction().commit();
        return optionalClient;

    }

    public List<Client> findAll() {
        em.getTransaction().begin();
        TypedQuery<Client> query = em.createQuery("select c from Client c", Client.class);
        List<Client> clients = query.getResultList();
        em.getTransaction().commit();
        return clients;
    }

    public void update(Client client) {
        em.getTransaction().begin();
        Client managedClient = em.find(Client.class, client.getId());
        if (managedClient != null) {
            managedClient.setFirstName(client.getFirstName());
            managedClient.setLastName(client.getLastName());
            managedClient.setBirthDate(client.getBirthDate());
            managedClient.setPhoneNumber(client.getPhoneNumber());
            managedClient.setAddress(client.getAddress());
            em.flush();
            em.getTransaction().commit();
            System.out.println("Updated Client: " + managedClient);
        } else {
            em.getTransaction().rollback();
            System.out.println("Failed to update Client: " + client);
        }
    }

    public void delete(Client client) {
        em.getTransaction().begin();
        Client managedClient = em.find(Client.class, client.getId());
        if (managedClient != null) {
            em.remove(managedClient);
            em.getTransaction().commit();
            System.out.println("Deleted Client: " + managedClient);
        } else {
            em.getTransaction().rollback();
            System.out.println("Failed to delete Client: " + client);
        }
    }
}
