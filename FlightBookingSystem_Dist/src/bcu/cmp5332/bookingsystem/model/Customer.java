package bcu.cmp5332.bookingsystem.model;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    
    private int id;
    private String name;
    private String phone;
    private final List<Booking> bookings = new ArrayList<>();
    
    public Customer(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Booking> getBookings() {
        return new ArrayList<>(bookings);
    }

    public void addBooking(Booking booking) {
        if (!bookings.contains(booking)) {
            bookings.add(booking);
        }
    }

    public void removeBooking(Booking booking) {
        bookings.remove(booking);
    }
}
