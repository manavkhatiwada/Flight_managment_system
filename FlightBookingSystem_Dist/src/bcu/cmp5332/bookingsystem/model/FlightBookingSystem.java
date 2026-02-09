package bcu.cmp5332.bookingsystem.model;

import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import java.time.LocalDate;
import java.util.*;

public class FlightBookingSystem {
    
    private final LocalDate systemDate = LocalDate.parse("2024-11-11");
    
    private final Map<Integer, Customer> customers = new TreeMap<>();
    private final Map<Integer, Flight> flights = new TreeMap<>();
    private final List<Booking> bookings = new ArrayList<>();

    public LocalDate getSystemDate() {
        return systemDate;
    }

    public List<Flight> getFlights() {
        List<Flight> out = new ArrayList<>(flights.values());
        return Collections.unmodifiableList(out);
    }

    public Flight getFlightByID(int id) throws FlightBookingSystemException {
        if (!flights.containsKey(id)) {
            throw new FlightBookingSystemException("There is no flight with that ID.");
        }
        return flights.get(id);
    }

    public Customer getCustomerByID(int id) throws FlightBookingSystemException {
        if (!customers.containsKey(id)) {
            throw new FlightBookingSystemException("There is no customer with that ID.");
        }
        return customers.get(id);
    }

    public void addFlight(Flight flight) throws FlightBookingSystemException {
        if (flights.containsKey(flight.getId())) {
            throw new IllegalArgumentException("Duplicate flight ID.");
        }
        for (Flight existing : flights.values()) {
            if (existing.getFlightNumber().equals(flight.getFlightNumber()) 
                && existing.getDepartureDate().isEqual(flight.getDepartureDate())) {
                throw new FlightBookingSystemException("There is a flight with same "
                        + "number and departure date in the system");
            }
        }
        flights.put(flight.getId(), flight);
    }

    public void addCustomer(Customer customer) throws FlightBookingSystemException {
        if (customers.containsKey(customer.getId())) {
            throw new FlightBookingSystemException("Duplicate customer ID.");
        }
        customers.put(customer.getId(), customer);
    }

    public List<Customer> getCustomers() {
        List<Customer> out = new ArrayList<>(customers.values());
        return Collections.unmodifiableList(out);
    }

    public void addBooking(Booking booking) throws FlightBookingSystemException {
        // Check if customer already has this flight booked
        Customer customer = booking.getCustomer();
        Flight flight = booking.getFlight();

        for (Booking existing : bookings) {
            if (existing.getCustomer().getId() == customer.getId()
                && existing.getFlight().getId() == flight.getId()) {
                throw new FlightBookingSystemException("Customer already has a booking on this flight.");
            }
        }

        bookings.add(booking);
        customer.addBooking(booking);
        flight.addPassenger(customer);
    }

    public void removeBooking(Booking booking) {
        bookings.remove(booking);
        booking.getCustomer().removeBooking(booking);
    }

    public List<Booking> getBookings() {
        return new ArrayList<>(bookings);
    }

    public Booking getBooking(int customerId, int flightId) throws FlightBookingSystemException {
        for (Booking booking : bookings) {
            if (booking.getCustomer().getId() == customerId
                && booking.getFlight().getId() == flightId) {
                return booking;
            }
        }
        throw new FlightBookingSystemException("No booking found for this customer and flight.");
    }
}
