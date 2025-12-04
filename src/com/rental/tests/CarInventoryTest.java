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
    private Car gasCar;
    private Car electricCar;
    private Customer customer;

    @BeforeEach
    void setUp() {
        // We initialize the inventory and cars before each test
        inventory = new CarInventory();
        gasCar = new GasCar("C001", "Toyota", "Corolla", 50.0);
        electricCar = new ElectricCar("E001", "Tesla", "Model 3", 80.0);
        customer = new Customer("U001", "John Doe");

        inventory.addCar(gasCar);
        inventory.addCar(electricCar);
    }

    @Test
    void testGasCarRentalFee() {
        // Test logic: 3 days * 50$ = 150$
        double fee = gasCar.calculateRentalFee(3);
        assertEquals(150.0, fee, "Gas car fee calculation is wrong.");
    }

    @Test
    void testElectricCarRentalFee() {
        // Test logic: (3 days * 80$) + 10$ fee = 250$
        double fee = electricCar.calculateRentalFee(3);
        assertEquals(250.0, fee, "Electric car fee calculation is wrong.");
    }

    @Test
    void testRentCarSuccessfully() {
        // 1. Verify car is available
        assertTrue(gasCar.isAvailable());
        
        // 2. Rent the car
        inventory.rentCar("C001", customer, 2);
        
        // 3. Verify car is NOT available anymore
        assertFalse(gasCar.isAvailable());
        assertEquals(1, inventory.getRentals().size());
    }

    @Test
    void testReturnCar() {
        inventory.rentCar("E001", customer, 1);
        inventory.returnCar("E001");
        
        // Car should be free again
        assertTrue(electricCar.isAvailable());
    }
}