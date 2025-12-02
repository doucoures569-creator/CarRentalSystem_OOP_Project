package com.rental.model;

public class ElectricCar extends Car {

    public ElectricCar(String carId, String brand, String model, double baseRatePerDay) {
        super(carId, brand, model, baseRatePerDay);
    }

    @Override
    public double calculateRentalFee(int days) {
        // Ajoute 10$ de frais fixes pour la recharge
        return (getBaseRatePerDay() * days) + 10;
    }
}