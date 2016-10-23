package com.test4javadev.pashkouski.service;

import com.test4javadev.pashkouski.dao.OrderDao;
import com.test4javadev.pashkouski.model.Order;

import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;

@WebService
public class OrderService {

    @Inject
    OrderDao orderDao;

    public Order get(int id) {
        return orderDao.get(id);
    }

    public List<Order> getAll() {
        return orderDao.getAll();
    }

    public Order save(Order order) {
        return orderDao.save(order);
    }

    public boolean delete(int id) {
        return orderDao.delete(id);
    }
}
