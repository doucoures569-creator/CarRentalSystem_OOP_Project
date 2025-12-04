package com.rental.main;

import com.rental.model.Car;
import com.rental.model.Customer;
import com.rental.model.ElectricCar;
import com.rental.model.GasCar;
import com.rental.service.CarInventory;

public class CarRentalApp {

    public static void main(String[] args) {
        System.out.println("--- STARTING CAR RENTAL SYSTEM ---");

        // 1. Initialize Inventory
        CarInventory inventory = new CarInventory();

        // 2. Create Cars (Polymorphism in action)
        Car toyota = new GasCar("C001", "Toyota", "Corolla", 50.0);
        Car tesla = new ElectricCar("C002", "Tesla", "Model 3", 80.0); // +10 fixed fee
        Car ford = new GasCar("C003", "Ford", "Fiesta", 40.0);

        // 3. Add Cars to System
        inventory.addCar(toyota);
        inventory.addCar(tesla);
        inventory.addCar(ford);

        // 4. Create a Customer
        Customer client1 = new Customer("U001", "Ali Yilmaz");

        // 5. Rent a Gas Car (3 days)
        // Calculation: 50 * 3 = 150
        inventory.rentCar("C001", client1, 3);

        // 6. Try to rent the same car again (Should fail)
        Customer client2 = new Customer("U002", "Ayse Demir");
        inventory.rentCar("C001", client2, 2);

        // 7. Return the car
        inventory.returnCar("C001");

        // 8. Rent an Electric Car (Test Polymorphism)
        // Calculation: (80 * 2) + 10 = 170
        inventory.rentCar("C002", client2, 2);
        
        System.out.println("--- DEMO FINISHED ---");
    }
}