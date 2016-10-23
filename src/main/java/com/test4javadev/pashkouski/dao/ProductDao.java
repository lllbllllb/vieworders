package com.test4javadev.pashkouski.dao;

import com.test4javadev.pashkouski.model.Product;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Stateless
@LocalBean
@Transactional
public class ProductDao {

    @PersistenceContext(unitName = "vieworders")
    private EntityManager em;

    public Product get(int id) {
        return em.find(Product.class, id);
    }

    public List<Product> getAll(int orderId) {
        List<Product> products = em.createNamedQuery(Product.GET_ALL_SORTED).setParameter("orderId", orderId).getResultList();
        System.out.printf("\ngetAllProduct: %s\n", products);
        return products;
    }
}
