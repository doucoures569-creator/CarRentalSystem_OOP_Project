package com.rental.main;

import java.util.Scanner;
import com.rental.model.Customer;
import com.rental.service.CarInventory;

public class CarRentalApp {

    public static void main(String[] args) {
        
        System.out.println("--- STARTING CAR RENTAL SYSTEM ---");
        
        // 1. Initialize Service (It will load cars from CSV automatically)
        CarInventory inventory = new CarInventory();
        
        // 2. Initialize Scanner for user input
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== WELCOME TO CAR RENTAL SYSTEM V2.0 ===");

        // 3. Infinite loop for the Menu
        while (true) {
            System.out.println("\n===========================");
            System.out.println("       MAIN MENU");
            System.out.println("===========================");
            System.out.println("1. Show Available Cars");
            System.out.println("2. Rent a Car");
            System.out.println("3. Return a Car");
            System.out.println("4. Exit Program");
            System.out.print(">> Enter your choice: ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Fix for skipping line issue
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.nextLine(); // Clear scanner buffer
                continue;
            }

            switch (choice) {
                case 1:
                    // Display cars loaded from CSV
                    inventory.displayAvailableCars();
                    break;

                case 2:
                    System.out.println("\n--- RENT A CAR ---");
                    System.out.print("Enter Car ID (e.g., C001): ");
                    String carId = scanner.nextLine();
                    
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter number of days: ");
                    int days = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    
                    // Create customer on the fly
                    Customer customer = new Customer("C" + System.currentTimeMillis(), name);
                    
                    // Process rental
                    inventory.rentCar(carId, customer, days);
                    break;

                case 3:
                    System.out.println("\n--- RETURN A CAR ---");
                    System.out.print("Enter Car ID to return: ");
                    String returnId = scanner.nextLine();
                    
                    // Process return
                    inventory.returnCar(returnId);
                    break;

                case 4:
                    System.out.println("Exiting system... Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please select 1-4.");
            }
        }
    }
}