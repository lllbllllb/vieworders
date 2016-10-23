package com.test4javadev.pashkouski.bean;

import com.test4javadev.pashkouski.model.Order;
import com.test4javadev.pashkouski.model.Product;
import com.test4javadev.pashkouski.service.OrderService;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@ManagedBean(name = "orderBean")
@ViewScoped
public class MainBean implements Serializable {

    private static final long serialVersionUID = 109419129003495251L;

    private List<Order> orders;

    @Inject
    private OrderService orderService;

    public List<Order> getOrders() {
        orders = orderService.getAll();
        System.out.printf("\ngetAllProduct: %s\n", orders);
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    private TreeNode root;

    @PostConstruct
    public void init() {
        root = new DefaultTreeNode("Root", null);

        for (Order o : getOrders()) {
            TreeNode orderNode = new DefaultTreeNode(o.toString(), root);
            for (Product p : o.getProducts()) {
                orderNode.getChildren().add(new DefaultTreeNode(p.toString()));
            }
        }
    }

    public TreeNode getRoot() {
        return root;
    }
}
