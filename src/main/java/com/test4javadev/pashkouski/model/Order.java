package com.test4javadev.pashkouski.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = Order.GET_WITH_PRODUCTS, query = "SELECT o FROM Order o LEFT JOIN o.products WHERE o.id=:id"),
        @NamedQuery(name = Order.GET_ALL_SORTED, query = "SELECT o FROM Order o JOIN FETCH o.products ORDER BY o.date DESC")
})
@Entity
@Table(name = "orders")
public class Order implements Serializable {
    private static final long serialVersionUID = 7184335194861844774L;

    public static final String GET_WITH_PRODUCTS = "Order.getWithProducts";
    public static final String GET_ALL_SORTED = "Order.getAll";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "amount")
    private int amount;

    @Column(name = "registered")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "parent")
    private List<Product> products;


    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (name != null ? !name.equals(order.name) : order.name != null) return false;
        return address != null ? address.equals(order.address) : order.address == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", products=" + products +
                '}';
    }
}
