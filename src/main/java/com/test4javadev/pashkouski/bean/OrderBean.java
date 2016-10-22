package com.test4javadev.pashkouski.bean;

import com.test4javadev.pashkouski.dao.OrderDao;
import com.test4javadev.pashkouski.model.Order;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "orderBean")
@ViewScoped
public class OrderBean implements Serializable {

    private static final long serialVersionUID = 109419129003495251L;


    Order order;

    private OrderDao orderDAO = new OrderDao();

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Order> getAll() {
        return orderDAO.getAll();
    }

    public Order getOrder() {
        return orderDAO.get();
    }

//    @PostConstruct
//    public void init() {
//        Order order = orderDAO.get();
//        System.out.println("!!!!!!!!!!!!!!!!!!!! " + order);
//    }
}
