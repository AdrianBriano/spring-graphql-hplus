package com.adrian.spring.graphql.hplus.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesPersonRepository extends JpaRepository<SalesPerson, Long> {

    SalesPerson findSalesPersonByEmail(String email);
}
