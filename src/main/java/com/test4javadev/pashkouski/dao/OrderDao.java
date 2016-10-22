package com.test4javadev.pashkouski.dao;

import com.test4javadev.pashkouski.model.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getAll();
    Order get();
}
