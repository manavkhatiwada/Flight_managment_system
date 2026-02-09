package bcu.cmp5332.bookingsystem.commands;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Booking;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;

public class CancelBooking implements Command {

    private final int customerId;
    private final int flightId;

    public CancelBooking(int customerId, int flightId) {
        this.customerId = customerId;
        this.flightId = flightId;
    }

    @Override
    public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
        Booking booking = flightBookingSystem.getBooking(customerId, flightId);
        flightBookingSystem.removeBooking(booking);
        System.out.println("Booking cancelled for Customer #" + customerId + " on Flight #" + flightId);
    }
}

