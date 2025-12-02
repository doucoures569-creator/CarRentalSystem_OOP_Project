package com.rental.model;

import com.rental.interfaces.Rentable;

public abstract class Car implements Rentable {
    private String carId;
    private String brand;
    private String model;
    private double baseRatePerDay;
    private boolean isAvailable;

    public Car(String carId, String brand, String model, double baseRatePerDay) {
        this.carId = carId;
        this.brand = brand;
        this.model = model;
        this.baseRatePerDay = baseRatePerDay;
        this.isAvailable = true;
    }

    public String getCarId() { return carId; }
    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public double getBaseRatePerDay() { return baseRatePerDay; }
    public boolean isAvailable() { return isAvailable; }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    @Override
    public String toString() {
        return brand + " " + model + " (" + carId + ")";
    }
}