package com.fdm.customer.controller;


import com.fdm.common.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wmansoor on 1/6/2019.
 */

@RestController
@RequestMapping("customer")
public class CustomerService {

    @GetMapping("/details/{customer-id}")
    public Customer post(@PathVariable("customer-id") final long customerId) {
        Customer customer = Customer.builder().id(customerId).name("Denzel Washington").contactNo("0322-2656894").build();
        return customer;
    }

}
