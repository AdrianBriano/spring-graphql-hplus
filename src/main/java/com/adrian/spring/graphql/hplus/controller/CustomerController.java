package com.adrian.spring.graphql.hplus.controller;

import com.adrian.spring.graphql.hplus.data.Customer;
import com.adrian.spring.graphql.hplus.data.CustomerInput;
import com.adrian.spring.graphql.hplus.data.CustomerRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerController {
    private final CustomerRepository customerRepository;

    CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @QueryMapping
    public Iterable<Customer> customers() {
        return customerRepository.findAll();
    }

    @QueryMapping
    public Customer customerById(@Argument Long customerId) {
        return customerRepository.findById(customerId).orElseThrow();
    }

    @QueryMapping
    public Customer customerByEmail(@Argument String email) {
        return  customerRepository.findCustomerByEmail(email);
    }

    @MutationMapping
    public Customer addCustomer(@Argument(name="input") CustomerInput customerInput) {
        return customerRepository.save(customerInput.getCustomerEntity());
    }
}
