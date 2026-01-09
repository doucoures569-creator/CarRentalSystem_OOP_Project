package com.rental.tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.rental.model.Car;
import com.rental.model.Customer;
import com.rental.model.ElectricCar;
import com.rental.model.GasCar;
import com.rental.service.CarInventory;

class CarInventoryTest {

    private CarInventory inventory;
    private Customer customer;

    @BeforeEach
    void setUp() {
        // 1. Initialize the inventory before each test
        inventory = new CarInventory();
        customer = new Customer("TestUser", "John Doe");
        
        // 2. Add test cars manually to ensure data exists for testing
        // (We do this to avoid depending on the CSV file during unit tests)
        inventory.addCar(new GasCar("TEST-G1", "Toyota", "TestGas", 50.0));
        inventory.addCar(new ElectricCar("TEST-E1", "Tesla", "TestElec", 80.0));
    }

    @Test
    void testGasCarRentalFee() {
        // Scenario: Renting a Gas Car for 3 days
        Car car = new GasCar("G1", "Brand", "Model", 50.0);
        double fee = car.calculateRentalFee(3);
        
        // Expected: 50.0 * 3 = 150.0
        assertEquals(150.0, fee, "Gas Car fee calculation is incorrect");
    }

    @Test
    void testElectricCarRentalFee() {
        // Scenario: Renting an Electric Car for 2 days
        Car car = new ElectricCar("E1", "Brand", "Model", 80.0);
        double fee = car.calculateRentalFee(2);
        
        // Expected: (80.0 * 2) + 20.0 (Charging Fee) = 180.0
        assertEquals(180.0, fee, "Electric Car fee calculation is incorrect");
    }
    
    @Test
    void testCarAvailability() {
        // Scenario: Checking if availability status changes correctly
        Car car = new GasCar("C1", "A", "B", 100);
        
        // It should be available initially
        assertTrue(car.isAvailable(), "New car should be available by default");
        
        // Change status to unavailable
        car.setAvailable(false);
        assertFalse(car.isAvailable(), "Car should be unavailable after setting it to false");
    }
}