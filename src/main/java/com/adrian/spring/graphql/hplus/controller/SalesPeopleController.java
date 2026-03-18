package com.adrian.spring.graphql.hplus.controller;

import com.adrian.spring.graphql.hplus.data.*;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class SalesPeopleController {
    private final SalesPeopleRepository salesPeopleRepository;

    public SalesPeopleController(SalesPeopleRepository salesPeopleRepository) {
        this.salesPeopleRepository = salesPeopleRepository;
    }

    @QueryMapping
    public Iterable<SalesPeople> salesPeople() {
        return salesPeopleRepository.findAll();
    }

    @QueryMapping
    public SalesPeople salesPersonById(@Argument Long salesPersonId) {
        return salesPeopleRepository.findById(salesPersonId).orElseThrow();
    }

    @QueryMapping
    public SalesPeople salesPersonByEmail(@Argument String email) {
        return  salesPeopleRepository.findSalesPersonByEmail(email);
    }
}
