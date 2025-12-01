package com.rental.model;

import com.rental.interfaces.Rentable;

public abstract class Car implements Rentable {
    private String vehicleId;
    private String model;
    private double baseRatePerDay;
    private boolean available;

    public Car(String vehicleId, String model, double baseRatePerDay) {
        this.vehicleId = vehicleId;
        this.model = model;
        this.baseRatePerDay = baseRatePerDay;
        this.available = true;
    }

    public abstract double calculateRentalFee(int days);

    public String getVehicleId() { return vehicleId; }
    public String getModel() { return model; }
    public double getBaseRatePerDay() { return baseRatePerDay; }

    @Override
    public boolean rent() {
        if (available) {
            available = false;
            return true;
        }
        return false;
    }

    @Override
    public boolean returnItem() {
        available = true;
        return true;
    }

    @Override
    public boolean isAvailable() {
        return available;
    }

    @Override
    public String toString() {
        return model + " (ID: " + vehicleId + ")";
    }
}
