package com.test4javadev.pashkouski.service;

import com.test4javadev.pashkouski.dao.ProductDao;
import com.test4javadev.pashkouski.model.Product;

import javax.inject.Inject;
import javax.jws.WebService;
import java.util.List;

@WebService
public class ProductService {

    @Inject
    ProductDao productDao;

    public Product get(int id) {
        return productDao.get(id);
    }

    public List<Product> getAll(int orderId) {
        return productDao.getAll(orderId);
    }
}
