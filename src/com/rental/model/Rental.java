package com.rental.model;

public class Rental {
    private Car car;
    private Customer customer;
    private int days;
    private double rentalFee;

    public Rental(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.days = days;
        this.rentalFee = car.calculateRentalFee(days); // Le calcul se fait automatiquement ici
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }

    public double getRentalFee() {
        return rentalFee;
    }
}