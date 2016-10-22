package com.test4javadev.pashkouski.bean;

import com.test4javadev.pashkouski.dao.OrderDao;
import com.test4javadev.pashkouski.dao.OrderDaoImpl;
import com.test4javadev.pashkouski.model.Order;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "orderBean")
@ViewScoped
public class OrderBean implements Serializable {

    private static final long serialVersionUID = 109419129003495251L;

    private OrderDao orderDAO = new OrderDaoImpl();

    public List<Order> getAll() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!");
        return orderDAO.getAll();
    }

    public Order getOrder() {
        Order order = orderDAO.get();
        System.out.println("!!!!!!!!!!!!!!!!!!!! " + order);
        return order;
    }

//    @PostConstruct
//    public void init() {
//        Order order = orderDAO.get();
//        System.out.println("!!!!!!!!!!!!!!!!!!!! " + order);
//    }
}
