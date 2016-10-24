package com.test4javadev.pashkouski.dao;

import com.test4javadev.pashkouski.model.Order;
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
        return em.createNamedQuery(Product.GET_ALL_SORTED).setParameter("orderId", orderId).getResultList();
    }

    @Transactional
    public Product save(Product product, int orderId) {
        product.setParent(em.getReference(Order.class, orderId));

        if (product.getId() == null) {
            em.persist(product);
            return product;
        } else {
            return em.merge(product);
        }
    }

    @Transactional
    public boolean delete (int id) {
        return em.createNamedQuery(Product.DELETE).setParameter("id", id).executeUpdate() != 0;
    }
}
