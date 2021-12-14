package com.codegym.service;

import com.codegym.model.Category;
import org.springframework.data.domain.Pageable;

public interface ICategoryService extends IGeneralService<Category>{
    Iterable<Category> findAll(Pageable pageable);
}
