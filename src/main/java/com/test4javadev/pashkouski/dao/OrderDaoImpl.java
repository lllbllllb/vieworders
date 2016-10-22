package com.test4javadev.pashkouski.dao;

import com.test4javadev.pashkouski.model.Order;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;
import java.util.List;

@Stateless
@LocalBean
public class OrderDaoImpl implements OrderDao {

    @PersistenceContext(unitName = "vieworders", type = PersistenceContextType.TRANSACTION)
    private EntityManager em;

    public List<Order> getAll() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!");
        Query query = em.createQuery("SELECT o FROM Order as o");
        System.out.println();
        List<Order> orders = query.getResultList();
        System.out.println("!!!!!!!!!!!!!!!!!!!!" + orders);
        return orders;
    }

    @Override
    public Order get() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!");
        return getAll().get(0);
    }
}
