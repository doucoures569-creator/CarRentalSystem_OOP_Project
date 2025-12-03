package com.rental.service;

import com.rental.model.Car;
import com.rental.model.Customer;
import com.rental.model.Rental;
import java.util.ArrayList;
import java.util.List;

public class CarInventory {
    private List<Car> cars;
    private List<Rental> rentals;

    public CarInventory() {
        this.cars = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
        System.out.println("Car added: " + car.getBrand() + " " + car.getModel());
    }

    public void removeCar(String carId) {
        cars.removeIf(c -> c.getCarId().equals(carId));
        System.out.println("Car removed with ID: " + carId);
    }

    public List<Car> getCars() {
        return cars;
    }
    
    public List<Rental> getRentals() {
        return rentals;
    }

    public void rentCar(String carId, Customer customer, int days) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId) && car.isAvailable()) {
                car.setAvailable(false);
                Rental rental = new Rental(car, customer, days);
                rentals.add(rental);
                System.out.println("\n--- SUCCESS ---");
                System.out.println("Rental confirmed for " + customer.getName());
                System.out.println("Car: " + car.getBrand() + " " + car.getModel());
                System.out.println("Total Fee: " + rental.getRentalFee());
                return;
            }
        }
        System.out.println("\n[Error] Car not found or already rented.");
    }

    public void returnCar(String carId) {
        for (Car car : cars) {
            if (car.getCarId().equals(carId) && !car.isAvailable()) {
                car.setAvailable(true);
                System.out.println("\nCar returned successfully: " + carId);
                return;
            }
        }
        System.out.println("[Error] Cannot return car. It might not be rented or does not exist.");
    }
}