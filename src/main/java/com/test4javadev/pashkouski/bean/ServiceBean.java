package com.test4javadev.pashkouski.bean;

import com.test4javadev.pashkouski.model.Order;
import com.test4javadev.pashkouski.model.Product;
import com.test4javadev.pashkouski.service.OrderService;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean(name = "treeService")
@ApplicationScoped
public class ServiceBean implements Serializable {

    private static final long serialVersionUID = 109419129003495251L;

    @Inject
    private OrderService orderService;

    public TreeNode createTree() {
        TreeNode root = new DefaultTreeNode("Root", null);

        for (Order o : orderService.getAll()) {
            TreeNode orderNode = new DefaultTreeNode(o, root);
            for (Product p : o.getProducts()) {
                orderNode.getChildren().add(new DefaultTreeNode(p));
            }
        }

        return root;
    }
}
