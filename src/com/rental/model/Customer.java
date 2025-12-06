package com.rental.model;

/**
 * Represents a customer in the rental system.
 * Stores basic personal information.
 */
public class Customer {
    private String customerId;
    private String name;

    /**
     * Constructor to create a new Customer.
     * @param customerId Unique ID of the customer
     * @param name Full name of the customer
     */
    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getCustomerId() {
        return customerId;
    }
}