package com.test4javadev.pashkouski.bean;

import com.test4javadev.pashkouski.model.Order;
import com.test4javadev.pashkouski.service.OrderService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "orderBean")
@ViewScoped
public class OrderBean implements Serializable {

    private static final long serialVersionUID = 109419129003495251L;

    private Order order;

    @Inject
    private OrderService orderService;

    public void setOrder(Order order) {
        System.out.println("setOrder");
        this.order = order;
    }

    public Order getOrder() {
        System.out.println("getOrder");
        order = orderService.get(1000);                 //must be changed
        return order;
    }

    public List<Order> getAll() {
        return orderService.getAll();
    }
}
