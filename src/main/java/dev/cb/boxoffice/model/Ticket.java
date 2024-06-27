package dev.cb.boxoffice.model;

import javax.persistence.*;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private int id;
    @Column(name = "ticket_numberPlace")
    private int numberPlace;
    @Column(name = "ticket_typePlace")
    private TypePlace typePlace;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_id")
    private Event event;

    public Ticket() {
    }

    public Ticket(int numberPlace, TypePlace typePlace, Client client, Event event) {
        this.numberPlace = numberPlace;
        this.typePlace = typePlace;
        this.client = client;
        this.event = event;
    }

    public Ticket(int id, int numberPlace, TypePlace typePlace, Client client, Event event) {
        this(numberPlace, typePlace, client, event);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public int getNumberPlace() {
        return numberPlace;
    }

    public void setNumberPlace(int numberPlace) {
        this.numberPlace = numberPlace;
    }

    public TypePlace getTypePlace() {
        return typePlace;
    }

    public void setTypePlace(TypePlace typePlace) {
        this.typePlace = typePlace;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", numberPlace=" + numberPlace +
                ", typePlace=" + typePlace +
                ", client=" + client +
                ", event=" + event +
                '}';
    }
}
