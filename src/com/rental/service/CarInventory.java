package com.rental.service;

import com.rental.model.Car;
import com.rental.model.Customer;
import com.rental.model.Rental;
import java.util.ArrayList;
import java.util.List;

/**
 * Service class that manages the car inventory and rental operations.
 * Acts as the main controller for the business logic.
 */
public class CarInventory {
    private List<Car> cars;
    private List<Rental> rentals;

    /**
     * Constructor to initialize empty lists for cars and rentals.
     */
    public CarInventory() {
        this.cars = new ArrayList<>();
        this.rentals = new ArrayList<>();
    }

    /**
     * Adds a new car to the inventory.
     * @param car The car object to add
     */
    public void addCar(Car car) {
        cars.add(car);
        System.out.println("Car added: " + car.getBrand() + " " + car.getModel());
    }

    /**
     * Removes a car from the inventory based on its ID.
     * @param carId The unique ID of the car to remove
     */
    public void removeCar(String carId) {
        cars.removeIf(c -> c.getCarId().equals(carId));
        System.out.println("Car removed with ID: " + carId);
    }

    public List<Car> getCars() { return cars; }
    public List<Rental> getRentals() { return rentals; }

    /**
     * Processes a car rental for a customer.
     * Checks availability before confirming the transaction.
     * @param carId The ID of the car to rent
     * @param customer The customer renting the car
     * @param days The duration of the rental
     */
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

    /**
     * Processes the return of a rented car.
     * Makes the car available again in the system.
     * @param carId The ID of the car being returned
     */
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