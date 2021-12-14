package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {
    private static final List<Product> products;

    static {
        products = new ArrayList<>();
        products.add(new Product(0, "iphone 14", 9999, "new"));
        products.add(new Product(1, "iphone 12", 999, "old"));
        products.add(new Product(2, "iphone 13", 1999, "new"));
        products.add(new Product(3, "iphone 11", 899, "old"));
        products.add(new Product(4, "iphone 10", 799, "old"));
        products.add(new Product(5, "iphone 9", 699, "new"));
        products.add(new Product(6, "iphone 8", 599, "old"));
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void save(Product product) {
        products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (id == product.getId()) {
                return product;
            }
        }
        return null;
    }

    @Override
    public int findByIndex(int id) {
        int index = -1;
        for (int i = 0; i < products.size(); i++) {
            if (id == products.get(i).getId()) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void update(int id, Product product) {
        products.set(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public Product findByName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return product;
            }
        }
        return null;
    }
}
