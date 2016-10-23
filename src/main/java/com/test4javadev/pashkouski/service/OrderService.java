package com.test4javadev.pashkouski.service;

import com.test4javadev.pashkouski.dao.OrderDao;
import com.test4javadev.pashkouski.dao.ProductDao;
import com.test4javadev.pashkouski.model.Order;
import com.test4javadev.pashkouski.model.Product;

import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;

@WebService
public class OrderService {

    @Inject
    OrderDao orderDao;

    @Inject
    ProductDao productDao;

    public Order get(int id) {
        Order order = orderDao.get(id);
        List<Product> products = productDao.getAll(id);
        order.setProducts(products);
        System.out.printf("\ngetOrder: %s\n", order);
        return order;
    }

    public List<Order> getAll() {
        return orderDao.getAll();
    }
}
