package com.test4javadev.pashkouski.model;

import javax.persistence.*;
import java.io.Serializable;

@NamedQueries({
        @NamedQuery(name = Product.GET_ALL_SORTED, query = "SELECT p FROM Product p WHERE p.parent.id=:orderId"),
        @NamedQuery(name = Product.DELETE, query = "DELETE FROM Product p WHERE p.id=:id")
})
@Entity
@Table(name = "products")
public class Product implements Serializable {
    private static final long serialVersionUID = 8801388160115903932L;

    public static final String GET_ALL_SORTED = "Product.getAll()";
    public static final String DELETE = "Product.delete";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "serialnumber")
    private String serialNumber;

    @Column(name = "description")
    private String description;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order parent;

    public Product() {
    }

    public Product(String serialNumber, String description, int quantity) {
        this.serialNumber = serialNumber;
        this.description = description;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getParent() {
        return parent;
    }

    public void setParent(Order orderwe) {
        this.parent = orderwe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (serialNumber != null ? !serialNumber.equals(product.serialNumber) : product.serialNumber != null)
            return false;
        return description != null ? description.equals(product.description) : product.description == null;

    }

    @Override
    public int hashCode() {
        int result = serialNumber != null ? serialNumber.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  description + " (S/N: " + serialNumber + "), " + quantity + " pcs";
    }
}
