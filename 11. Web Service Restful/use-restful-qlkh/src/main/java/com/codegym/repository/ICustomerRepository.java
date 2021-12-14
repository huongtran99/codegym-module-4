package com.codegym.repository;

import com.codegym.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    @Query(value = "select customers.* from customers join role r on r.id = customers.role_id where r.id = ?", nativeQuery = true)
    Iterable<Customer> showCustomerByRole(Long id);
}