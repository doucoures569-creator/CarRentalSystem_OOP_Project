package com.rental.model;

public class GasCar extends Car {

    public GasCar(String carId, String brand, String model, double baseRatePerDay) {
        super(carId, brand, model, baseRatePerDay);
    }

    @Override
    public double calculateRentalFee(int days) {
        return getBaseRatePerDay() * days;
    }
}