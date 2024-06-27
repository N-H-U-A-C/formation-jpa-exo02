package dev.cb.boxoffice.persistence;


import dev.cb.boxoffice.model.Event;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class EventRepository {

    private EntityManager em;

    public EventRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Event event) {
        em.getTransaction().begin();
        em.persist(event);
        em.getTransaction().commit();
        System.out.println("Event saved: " + event);
    }

    public Optional<Event> findById(int id) {
        em.getTransaction().begin();
        Optional<Event> optionalEvent = Optional.ofNullable(em.find(Event.class, id));
        em.getTransaction().commit();
        return optionalEvent;

    }

    public List<Event> findAll() {
        em.getTransaction().begin();
        TypedQuery<Event> query = em.createQuery("select e from Event e", Event.class);
        List<Event> events = query.getResultList();
        em.getTransaction().commit();
        return events;
    }

    public void update(Event event) {
        em.getTransaction().begin();
        Event managedEvent = em.find(Event.class, event.getId());
        if (managedEvent != null) {
            managedEvent.setLabel(event.getLabel());
            managedEvent.setDateTime(event.getDateTime());
            managedEvent.setQuantityPlace(event.getQuantityPlace());
            managedEvent.setAddress(event.getAddress());
            em.flush();
            em.getTransaction().commit();
            System.out.println("Updated Event: " + managedEvent);
        } else {
            em.getTransaction().rollback();
            System.out.println("Failed to update Event: " + event);
        }
    }

    public void delete(Event event) {
        em.getTransaction().begin();
        Event managedEvent = em.find(Event.class, event.getId());
        if (managedEvent != null) {
            em.remove(managedEvent);
            em.getTransaction().commit();
            System.out.println("Deleted Event: " + managedEvent);
        } else {
            em.getTransaction().rollback();
            System.out.println("Failed to delete Event: " + event);
        }
    }
}
