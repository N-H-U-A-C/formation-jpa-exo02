package dev.cb.boxoffice.model;

import javax.persistence.*;

@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "adress_id")
    private int id;
    @Column(name = "adress_streetname")
    private String streetName;
    @Column(name = "adress_city")
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
