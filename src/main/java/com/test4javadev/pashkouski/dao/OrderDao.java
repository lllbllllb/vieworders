package com.test4javadev.pashkouski.dao;

import com.test4javadev.pashkouski.model.Order;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
@LocalBean
@Transactional
public class OrderDao {

    @PersistenceContext(unitName = "vieworders")
    private EntityManager em;

    //for update window (coming soon)
    public Order get(int id) {
        return em.createNamedQuery(Order.GET_WITH_PRODUCTS, Order.class).setParameter("id", id).getSingleResult();
    }

    public List<Order> getAll() {
        return em.createNamedQuery(Order.GET_ALL_SORTED, Order.class).getResultList();
    }

    @Transactional
    public Order save(Order order) {
        if (order.getId() == null) {
            em.persist(order);
            return order;
        } else {
            return em.merge(order);
        }
    }

    @Transactional
    public boolean delete(int id) {
        return em.createNamedQuery(Order.DELETE).setParameter("id", id).executeUpdate() != 0;
    }
}
