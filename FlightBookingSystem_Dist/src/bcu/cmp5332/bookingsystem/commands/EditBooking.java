package bcu.cmp5332.bookingsystem.commands;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Booking;
import bcu.cmp5332.bookingsystem.model.Flight;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;
import java.time.LocalDate;

public class EditBooking implements Command {

    private final int customerId;
    private final int newFlightId;
    private final LocalDate bookingDate;

    public EditBooking(int customerId, int newFlightId, LocalDate bookingDate) {
        this.customerId = customerId;
        this.newFlightId = newFlightId;
        this.bookingDate = bookingDate;
    }

    @Override
    public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
        // Find the first booking for this customer and change flight
        for (Booking booking : flightBookingSystem.getBookings()) {
            if (booking.getCustomer().getId() == customerId) {
                Flight newFlight = flightBookingSystem.getFlightByID(newFlightId);
                booking.setFlight(newFlight);
                booking.setBookingDate(bookingDate);
                System.out.println("Booking updated for Customer #" + customerId
                        + " to Flight #" + newFlightId);
                return;
            }
        }
        throw new FlightBookingSystemException("No booking found for customer #" + customerId);
    }
}

