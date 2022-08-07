package br.edu.ifsp.class02.task;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Rental {
    private Integer id;
    private Customer customer;
    private List<Dvd> dvds;
    private LocalDateTime rentalDate;

    public Rental(Integer id, Customer customer, List<Dvd> dvds, LocalDateTime rentalDate) {
        this.id = id;
        this.customer = customer;
        this.dvds = dvds;
        this.rentalDate = rentalDate;
    }

    public void addDvdRental(Dvd dvd) {
        this.dvds.add(dvd);
    }

    public Integer getId() {
        return id;
    }

    public List<Dvd> getDvds() {
        return dvds;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm");
        return "Rental #" + id +
                "\n" + customer +
                "\n" + dvds +
                "\n Rental date: " + rentalDate.format(dateTimeFormatter);
    }
}
