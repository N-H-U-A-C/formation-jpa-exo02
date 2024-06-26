package dev.cb.boxoffice.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private int id;
    @Column(name = "event_label")
    private String label;
    @Column(name = "event_datetime")
    private LocalDateTime dateTime;
    @Column(name = "event_quantityplace")
    private int quantityPlace;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

    public Event() {
    }

    public Event(String label, LocalDateTime dateTime, int quantityPlace, Address address) {
        this.label = label;
        this.dateTime = dateTime;
        this.quantityPlace = quantityPlace;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", dateTime=" + dateTime +
                ", numberPlace=" + quantityPlace +
                ", address=" + address +
                '}';
    }
}
