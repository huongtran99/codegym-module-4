package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGeneralService<Product> {
    Page<Product> findAllByProductNameContaining(String productName, Pageable pageable);

    Page<Product> findProductByCategory(String categoryName, Pageable pageable);
}
