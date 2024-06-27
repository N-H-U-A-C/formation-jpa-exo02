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

    @OneToOne(cascade = CascadeType.ALL)
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

    public Event(int id, String label, LocalDateTime dateTime, int quantityPlace, Address address) {
        this(label, dateTime, quantityPlace, address);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public int getQuantityPlace() {
        return quantityPlace;
    }

    public void setQuantityPlace(int quantityPlace) {
        this.quantityPlace = quantityPlace;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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
