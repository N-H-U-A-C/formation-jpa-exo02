package dev.cb.boxoffice.persistence;

import dev.cb.boxoffice.model.Address;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class AddressRepository {

    private EntityManager em;

    public AddressRepository(EntityManager em) {
        this.em = em;
    }

    public void save(Address address) {
        em.getTransaction().begin();

        em.persist(address);

        em.getTransaction().commit();
    }

    public Optional<Address> findById(int id) {
        em.getTransaction().begin();
        Optional<Address> optionalAddress = Optional.ofNullable(em.find(Address.class, id));
        em.getTransaction().commit();
        return optionalAddress;

    }

    public List<Address> findAll() {
        em.getTransaction().begin();
        TypedQuery<Address> query = em.createQuery("select a from Address a", Address.class);
        List<Address> addresses = query.getResultList();
        em.getTransaction().commit();
        return addresses;
    }


}
