package dev.cb.boxoffice.persistence;


import dev.cb.boxoffice.model.Ticket;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class TicketRepository {

    private EntityManager em;

    public TicketRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Ticket ticket) {
        em.getTransaction().begin();
        em.persist(ticket);
        em.getTransaction().commit();
        System.out.println("Ticket saved: " + ticket);
    }

    public Optional<Ticket> findById(int id) {
        em.getTransaction().begin();
        Optional<Ticket> optionalTicket = Optional.ofNullable(em.find(Ticket.class, id));
        em.getTransaction().commit();
        return optionalTicket;

    }

    public List<Ticket> findAll() {
        em.getTransaction().begin();
        TypedQuery<Ticket> query = em.createQuery("select t from Ticket t", Ticket.class);
        List<Ticket> tickets = query.getResultList();
        em.getTransaction().commit();
        return tickets;
    }

    public void update(Ticket ticket) {
        em.getTransaction().begin();
        Ticket managedTicket = em.find(Ticket.class, ticket.getId());
        if (managedTicket != null) {
            managedTicket.setNumberPlace(ticket.getNumberPlace());
            managedTicket.setTypePlace(ticket.getTypePlace());
            managedTicket.setClient((ticket.getClient()));
            managedTicket.setEvent(ticket.getEvent());
            em.flush();
            em.getTransaction().commit();
            System.out.println("Updated Ticket: " + managedTicket);
        } else {
            em.getTransaction().rollback();
            System.out.println("Failed to update Ticket: " + ticket);
        }
    }

    public void delete(Ticket ticket) {
        em.getTransaction().begin();
        Ticket managedTicket = em.find(Ticket.class, ticket.getId());
        if (managedTicket != null) {
            em.remove(managedTicket);
            em.getTransaction().commit();
            System.out.println("Deleted Ticket: " + managedTicket);
        } else {
            em.getTransaction().rollback();
            System.out.println("Failed to delete Ticket: " + ticket);
        }
    }
}
