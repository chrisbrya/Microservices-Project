package com.chrisbry.customer.service.service;

import com.chrisbry.customer.service.entity.Customer;
import com.chrisbry.customer.service.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    public Customer saveCustomer(Customer customer) {
        log.info("Inside saveCustomer of CustomerService");
        return customerRepository.save(customer);
    }

    public Customer findByCustomerId(Long customerId) {
        log.info("Inside findCustomerById of CustomerService");
        return customerRepository.findByCustomerId(customerId);
    }
}
