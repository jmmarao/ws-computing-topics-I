package br.edu.ifsp.class02.task;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class RentalStoreTest {
    private static Dvd dvd1;
    private static Dvd dvd2;
    private static Dvd dvd3;
    private static Customer customer1;
    private static Customer customer2;

    private static Rental rental;

    private static RentalStore rentalStore;

    @BeforeAll
    static void mockInitialize() {
        dvd1 = new Dvd(1, "Mercury", "Mercury is the fifth studio album by American pop rock band Imagine Dragons , released on September 3, 2021");
        dvd2 = new Dvd(2, "Happier Than Ever", "Happier Than Ever is the second studio album by American singer Billie Eilish , released on July 30, 2021");
        dvd3 = new Dvd(3, "Human", "Human is the fifth studio album by American band OneRepublic , released on August 27,2021.");

        customer1 = new Customer(1, "Thor", "000.000.000-00");
        customer2 = new Customer(2, "Hulk", "111.111.111-11");

        rental = new Rental(1, customer1, LocalDateTime.of(2022, 8, 22, 16, 20));
        rental.addDvdRental(dvd1);
        rental.addDvdRental(dvd2);

        rentalStore = new RentalStore();
        rentalStore.addRental(rental);
    }

    @Test
    @DisplayName("Checking the quantity of dvds rentals")
    void testCase1() {
        System.out.println(rental);
        System.out.println("\n---------------------------------------------------------");

        assertEquals(2, rental.getDvds().size());
    }

    @Test
    @DisplayName("Checking if a new dvd has been added")
    void testCase2() {
        rental.addDvdRental(dvd3);

        System.out.println(rental);
        System.out.println("\n---------------------------------------------------------");

        assertEquals(3, rental.getDvds().size());
    }

    @Test
    @DisplayName("Checking if the rental has been added")
    void testCase3() {
        assertEquals(rental, rentalStore.findRentalById(rental.getId()));
    }

    @Test
    @DisplayName("Checking if a new rental has been added")
    void testCase4() {
        Rental rentalToAdd = new Rental(2, customer2, LocalDateTime.of(2022, 8, 8, 23, 55));
        rentalToAdd.addDvdRental(dvd1);
        rentalToAdd.addDvdRental(dvd2);
        rentalStore.addRental(rentalToAdd);

        System.out.println(rentalStore);
        assertEquals(2, rentalStore.getRentals().size());
    }
}