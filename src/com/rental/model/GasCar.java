package com.rental.model;

/**
 * Concrete class representing a gasoline-powered car.
 * It inherits from the abstract Car class.
 */
public class GasCar extends Car {

    /**
     * Constructor for GasCar.
     * @param carId Unique ID
     * @param brand Car Brand
     * @param model Car Model
     * @param baseRatePerDay Price per day
     */
    public GasCar(String carId, String brand, String model, double baseRatePerDay) {
        super(carId, brand, model, baseRatePerDay);
    }

    /**
     * Calculates the rental fee for a gas car.
     * Standard calculation: rate * days.
     */
    @Override
    public double calculateRentalFee(int days) {
        return getBaseRatePerDay() * days;
    }
}