package com.codegym.repository;

import com.codegym.model.Image;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IImageRepository extends PagingAndSortingRepository<Image, Long> {
}
