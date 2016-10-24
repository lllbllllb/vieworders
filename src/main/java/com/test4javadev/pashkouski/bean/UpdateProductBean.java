package com.test4javadev.pashkouski.bean;

import com.test4javadev.pashkouski.model.Order;
import com.test4javadev.pashkouski.model.Product;
import com.test4javadev.pashkouski.service.ProductService;
import org.primefaces.push.EventBus;
import org.primefaces.push.EventBusFactory;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean(name = "updateProductBean")
public class UpdateProductBean implements Serializable {

    private static final long serialVersionUID = 5966332008465161835L;

    @Inject
    ProductService productService;

    private int id;

    private String serial = "serial number";

    private String description = "description";

    private String quantity = "enter the number";

    public String apply() {
        int q = Integer.parseInt(quantity);
        Product product = new Product(serial,  description, q);

        productService.save(product, id);

        return "orders.xhtml?faces-redirect=true";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
