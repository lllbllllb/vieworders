package com.test4javadev.pashkouski.dao;

import com.test4javadev.pashkouski.model.Order;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class OrderDao {

    @PersistenceContext(unitName = "vieworders")
    private EntityManager em;

    public List<Order> getAll() {
        Query query = em.createQuery("SELECT o FROM Order as o");
        List<Order> orders = query.getResultList();
        return orders;
    }

    public Order get() {
        return getAll().get(0);
    }
}
