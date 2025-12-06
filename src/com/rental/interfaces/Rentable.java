package com.rental.interfaces;

/**
 * Interface representing any item that can be rented in the system.
 * Enforces the calculation of rental fees.
 */
public interface Rentable {
    
    /**
     * Calculates the cost of renting the item.
     * @param days Number of rental days
     * @return The total cost
     */
    double calculateRentalFee(int days);
}