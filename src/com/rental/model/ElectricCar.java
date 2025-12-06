package com.rental.model;

/**
 * Concrete class representing an electric car.
 * It includes specific logic for charging fees.
 */
public class ElectricCar extends Car {

    /**
     * Constructor for ElectricCar.
     * @param carId Unique ID
     * @param brand Car Brand
     * @param model Car Model
     * @param baseRatePerDay Price per day
     */
    public ElectricCar(String carId, String brand, String model, double baseRatePerDay) {
        super(carId, brand, model, baseRatePerDay);
    }

    /**
     * Calculates the rental fee for an electric car.
     * Logic: (rate * days) + 10.0 fixed charging fee.
     */
    @Override
    public double calculateRentalFee(int days) {
        return (getBaseRatePerDay() * days) + 10;
    }
}