package br.edu.ifsp.class02.task;

import java.util.List;

public class RentalCompany {
    private List<Rental> rentals;

    public RentalCompany(List<Rental> rentals) {
        this.rentals = rentals;
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
        return "RentalCompany" +
                "\n" + rentals;
    }
}
