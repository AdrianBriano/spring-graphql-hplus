package com.adrian.spring.graphql.hplus.data;

import jakarta.persistence.*;

@Entity
@Table(name="ORDERS")
public class Order {

    @Id
    @Column(name="ORDER_ID")
    private String orderId;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", nullable = false, updatable = false)
    private Customer customer;


    @ManyToOne
    @JoinColumn(name = "SALESPERSON_ID", nullable = false, updatable = false)
    private SalesPerson salesPerson;
}
