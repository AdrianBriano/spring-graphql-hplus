package com.adrian.spring.graphql.hplus.controller;

import com.adrian.spring.graphql.hplus.data.*;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SalesPersonController {
    private final SalesPersonRepository salesPersonRepository;

    public SalesPersonController(SalesPersonRepository salesPersonRepository) {
        this.salesPersonRepository = salesPersonRepository;
    }

    @QueryMapping
    public Iterable<SalesPerson> salesPeople() {
        return salesPersonRepository.findAll();
    }

    @QueryMapping
    public SalesPerson salesPersonById(@Argument Long salesPersonId) {
        return salesPersonRepository.findById(salesPersonId).orElseThrow();
    }

    @QueryMapping
    public SalesPerson salesPersonByEmail(@Argument String email) {
        return  salesPersonRepository.findSalesPersonByEmail(email);
    }
}
