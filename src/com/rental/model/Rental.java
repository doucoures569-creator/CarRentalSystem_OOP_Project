package com.rental.model;

/**
 * Represents a rental transaction linking a car to a customer.
 * Automatically calculates and stores the final fee upon creation.
 */
public class Rental {
    private Car car;
    private Customer customer;
    private int days;
    private double rentalFee;

    /**
     * Creates a new Rental contract.
     * @param car The car being rented
     * @param customer The customer renting the car
     * @param days Duration of the rental in days
     */
    public Rental(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.days = days;
        // Logic: Calculate fee immediately using the car's specific formula
        this.rentalFee = car.calculateRentalFee(days); 
    }

    public Car getCar() { return car; }
    public Customer getCustomer() { return customer; }
    public int getDays() { return days; }
    public double getRentalFee() { return rentalFee; }
}