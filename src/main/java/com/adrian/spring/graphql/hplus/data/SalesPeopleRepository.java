package com.adrian.spring.graphql.hplus.data;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SalesPeopleRepository extends JpaRepository<SalesPeople, Long> {

    SalesPeople findSalesPersonByEmail(String email);
}
