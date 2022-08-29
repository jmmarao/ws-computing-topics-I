package br.edu.ifsp.class02.task;

import java.util.ArrayList;
import java.util.List;

public class RentalStore {
    private List<Rental> rentals = new ArrayList<>();

    public RentalStore() {

    }

    public void addRental(Rental rental) {
        rentals.add(rental);
    }

    public Rental findRentalById(Integer rentalId) {
        for (Rental rental : rentals) {
            if (rental.getId().equals(rentalId))
                return rental;
        }

        return null;
    }

    public List<Rental> getRentals() {
        return rentals;
    }

    @Override
    public String toString() {
        return "Rental Story" +
                "\n" + rentals;
    }
}
