package bcu.cmp5332.bookingsystem.commands;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Customer;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;

public class ShowCustomer implements Command {

    private final int customerId;

    public ShowCustomer(int customerId) {
        this.customerId = customerId;
    }

    @Override
    public void execute(FlightBookingSystem flightBookingSystem) throws FlightBookingSystemException {
        Customer customer = flightBookingSystem.getCustomerByID(customerId);
        System.out.println("Customer #" + customer.getId() + " - " + customer.getName()
                + " (" + customer.getPhone() + ")");
        System.out.println("Bookings: " + customer.getBookings().size());
        for (int i = 0; i < customer.getBookings().size(); i++) {
            System.out.println((i + 1) + ". " + customer.getBookings().get(i).getDetailsShort());
        }
    }
}

