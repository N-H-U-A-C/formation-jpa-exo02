package dev.cb.boxoffice.model;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int id;
    @Column(name = "address_streetname")
    private String streetName;
    @Column(name = "address_city")
    private String city;

    public Address() {
    }

    public Address(String streetName, String city) {
        this.streetName = streetName;
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
