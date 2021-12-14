package com.codegym.service.customer;

import com.codegym.model.Customer;
import com.codegym.service.IGeneralService;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> showCustomerByRole(Long id);
}
