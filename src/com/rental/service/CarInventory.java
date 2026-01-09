package com.rental.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.rental.model.Car;
import com.rental.model.Customer;
import com.rental.model.ElectricCar;
import com.rental.model.GasCar;
import com.rental.model.Rental;

public class CarInventory {

    private List<Car> cars;
    private List<Rental> rentals;
    
    // The name of the CSV file
    private static final String CSV_FILE = "cars.csv";

    public CarInventory() {
        this.cars = new ArrayList<>();
        this.rentals = new ArrayList<>();
        // Load data automatically when the service starts
        loadCarsFromCSV();
    }

    // --- METHOD TO READ THE CSV FILE ---
    private void loadCarsFromCSV() {
        try (BufferedReader br = new BufferedReader(new FileReader(CSV_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line by comma
                String[] data = line.split(",");

                // Parse data
                String type = data[0].trim();
                String id = data[1].trim();
                String brand = data[2].trim();
                String model = data[3].trim();
                double price = Double.parseDouble(data[4].trim());

                if (type.equalsIgnoreCase("Gas")) {
                    cars.add(new GasCar(id, brand, model, price));
                } else if (type.equalsIgnoreCase("Electric")) {
                    cars.add(new ElectricCar(id, brand, model, price));
                }
            }
            System.out.println("--> SYSTEM: Data loaded successfully from " + CSV_FILE);
        } catch (Exception e) {
            System.out.println("--> ERROR: Could not read CSV file. " + e.getMessage());
        }
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public void rentCar(String carId, Customer customer, int days) {
        Car selectedCar = null;
        for (Car car : cars) {
            if (car.getCarId().equalsIgnoreCase(carId)) {
                selectedCar = car;
                break;
            }
        }

        if (selectedCar != null && selectedCar.isAvailable()) {
            selectedCar.setAvailable(false);
            Rental rental = new Rental(selectedCar, customer, days);
            rentals.add(rental);
            
            System.out.println("\n--- SUCCESS ---");
            System.out.println("Rental confirmed for " + customer.getName());
            System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
            System.out.println("Total Fee: " + rental.getRentalFee());
        } else {
            System.out.println("\n--- ERROR ---");
            System.out.println("Car not found or already rented.");
        }
    }

    public void returnCar(String carId) {
        Rental rentalToRemove = null;
        for (Rental rental : rentals) {
            if (rental.getCar().getCarId().equalsIgnoreCase(carId)) {
                rentalToRemove = rental;
                break;
            }
        }

        if (rentalToRemove != null) {
            rentalToRemove.getCar().setAvailable(true);
            rentals.remove(rentalToRemove);
            System.out.println("\n--- SUCCESS ---");
            System.out.println("Car returned successfully: " + carId);
        } else {
            System.out.println("\n--- ERROR ---");
            System.out.println("No active rental found for this Car ID.");
        }
    }

    public void displayAvailableCars() {
        System.out.println("\n--- AVAILABLE CARS ---");
        for (Car car : cars) {
            if (car.isAvailable()) {
                System.out.println(car); 
            }
        }
    }
}