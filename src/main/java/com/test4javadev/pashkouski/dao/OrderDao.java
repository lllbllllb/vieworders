package com.test4javadev.pashkouski.dao;

import com.test4javadev.pashkouski.model.Order;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
@LocalBean
@Transactional
public class OrderDao {

    @PersistenceContext(unitName = "vieworders")
    private EntityManager em;


    public Order get(int id) {
        return em.find(Order.class, id);
//        Query query = em.createNamedQuery(Order.GET_WITH_PRODUCTS, Order.class).setParameter("id", id);
//        Order order = (Order)query.getResultList().get(0);
//        System.out.printf("\ngetOrder: %s\n", order);
//        return order;
    }

//    public Order getWithProducts(int id) {
//        Query query = em.createNamedQuery(Order.GET_WITH_PRODUCTS, Order.class);
//        Order order = (Order)query.getResultList().get(0);
//        System.out.printf("\ngetWithProducts: %s\n", order);
//        return order;
//    }

    public List<Order> getAll() {
        Query query = em.createNamedQuery(Order.GET_ALL_SORTED, Order.class);
        List<Order> orders = query.getResultList();
        return orders;
    }
}
