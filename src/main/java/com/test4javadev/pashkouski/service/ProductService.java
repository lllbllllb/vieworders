package com.test4javadev.pashkouski.service;

import com.test4javadev.pashkouski.dao.ProductDao;
import com.test4javadev.pashkouski.model.Product;

import javax.inject.Inject;
import javax.jws.WebService;
import javax.transaction.Transactional;
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

    public Product save(Product product, int orderId) {
        return productDao.save(product, orderId);
    }

    public boolean delete(int id) {
        return productDao.delete(id);
    }
}
