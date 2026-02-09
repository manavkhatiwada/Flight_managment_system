package bcu.cmp5332.bookingsystem.gui;

import bcu.cmp5332.bookingsystem.data.FlightBookingSystemData;
import bcu.cmp5332.bookingsystem.model.Booking;
import bcu.cmp5332.bookingsystem.model.Flight;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

public class MainWindow extends JFrame implements ActionListener {

    private JMenuBar menuBar;
    private JMenu adminMenu;
    private JMenu flightsMenu;
    private JMenu bookingsMenu;
    private JMenu customersMenu;

    private JMenuItem adminExit;

    private JMenuItem flightsView;
    private JMenuItem flightsAdd;
    private JMenuItem flightsDel;
    
    private JMenuItem bookingsView;
    private JMenuItem bookingsIssue;
    private JMenuItem bookingsUpdate;
    private JMenuItem bookingsCancel;

    private JMenuItem custView;
    private JMenuItem custAdd;
    private JMenuItem custDel;

    private FlightBookingSystem fbs;

    public MainWindow(FlightBookingSystem fbs) {

        initialize();
        this.fbs = fbs;
    }
    
    public FlightBookingSystem getFlightBookingSystem() {
        return fbs;
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {

        }

        setTitle("Flight Booking Management System");

        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        //adding adminMenu menu and menu items
        adminMenu = new JMenu("Admin");
        menuBar.add(adminMenu);

        adminExit = new JMenuItem("Exit");
        adminMenu.add(adminExit);
        adminExit.addActionListener(this);

        // adding Flights menu and menu items
        flightsMenu = new JMenu("Flights");
        menuBar.add(flightsMenu);

        flightsView = new JMenuItem("View");
        flightsAdd = new JMenuItem("Add");
        flightsDel = new JMenuItem("Delete");
        flightsMenu.add(flightsView);
        flightsMenu.add(flightsAdd);
        flightsMenu.add(flightsDel);
        // adding action listener for Flights menu items
        for (int i = 0; i < flightsMenu.getItemCount(); i++) {
            flightsMenu.getItem(i).addActionListener(this);
        }
        
        // adding Bookings menu and menu items
        bookingsMenu = new JMenu("Bookings");
        menuBar.add(bookingsMenu);

        bookingsView = new JMenuItem("View");
        bookingsIssue = new JMenuItem("Issue");
        bookingsUpdate = new JMenuItem("Update");
        bookingsCancel = new JMenuItem("Cancel");
        bookingsMenu.add(bookingsView);
        bookingsMenu.add(bookingsIssue);
        bookingsMenu.add(bookingsUpdate);
        bookingsMenu.add(bookingsCancel);
        // adding action listener for Bookings menu items
        for (int i = 0; i < bookingsMenu.getItemCount(); i++) {
            bookingsMenu.getItem(i).addActionListener(this);
        }

        // adding Customers menu and menu items
        customersMenu = new JMenu("Customers");
        menuBar.add(customersMenu);

        custView = new JMenuItem("View");
        custAdd = new JMenuItem("Add");
        custDel = new JMenuItem("Delete");

        customersMenu.add(custView);
        customersMenu.add(custAdd);
        customersMenu.add(custDel);
        // adding action listener for Customers menu items
        custView.addActionListener(this);
        custAdd.addActionListener(this);
        custDel.addActionListener(this);

        setSize(800, 500);

        setVisible(true);
        setAutoRequestFocus(true);
        toFront();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
/* Uncomment the following line to not terminate the console app when the window is closed */
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);        

    }	

/* Uncomment the following code to run the GUI version directly from the IDE */
//    public static void main(String[] args) throws IOException, FlightBookingSystemException {
//        FlightBookingSystem fbs = FlightBookingSystemData.load();
//        new MainWindow(fbs);			
//    }



    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == adminExit) {
            try {
                FlightBookingSystemData.store(fbs);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, ex, "Error", JOptionPane.ERROR_MESSAGE);
            }
            System.exit(0);
        } else if (ae.getSource() == flightsView) {
            displayFlights();
            
        } else if (ae.getSource() == flightsAdd) {
            new AddFlightWindow(this);
            
        } else if (ae.getSource() == flightsDel) {
            deleteFlightDialog();
            saveData();

        } else if (ae.getSource() == bookingsView) {
            displayBookings();

        } else if (ae.getSource() == bookingsIssue) {
            new AddBookingWindow(this);
            saveData();

        } else if (ae.getSource() == bookingsUpdate) {
            updateBookingDialog();
            saveData();

        } else if (ae.getSource() == bookingsCancel) {
            cancelBookingDialog();
            saveData();

        } else if (ae.getSource() == custView) {
            new ViewCustomersWindow(this);

        } else if (ae.getSource() == custAdd) {
            new AddCustomerWindow(this);
            saveData();

        } else if (ae.getSource() == custDel) {
            deleteCustomerDialog();
            saveData();
        }
    }

    private void deleteFlightDialog() {
        String flightIdStr = JOptionPane.showInputDialog(this, "Enter Flight ID to delete:");
        if (flightIdStr == null || flightIdStr.trim().isEmpty()) {
            return;
        }
        try {
            int flightId = Integer.parseInt(flightIdStr);
            fbs.removeFlight(flightId);
            JOptionPane.showMessageDialog(this, "Flight deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            displayFlights();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteCustomerDialog() {
        String customerIdStr = JOptionPane.showInputDialog(this, "Enter Customer ID to delete:");
        if (customerIdStr == null || customerIdStr.trim().isEmpty()) {
            return;
        }
        try {
            int customerId = Integer.parseInt(customerIdStr);
            fbs.removeCustomer(customerId);
            JOptionPane.showMessageDialog(this, "Customer deleted successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            // Optionally refresh customer view
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateBookingDialog() {
        String customerIdStr = JOptionPane.showInputDialog(this, "Enter Customer ID:");
        if (customerIdStr == null || customerIdStr.trim().isEmpty()) {
            return;
        }
        try {
            int customerId = Integer.parseInt(customerIdStr);
            String newFlightIdStr = JOptionPane.showInputDialog(this, "Enter new Flight ID:");
            int newFlightId = Integer.parseInt(newFlightIdStr);

            for (Booking booking : fbs.getBookings()) {
                if (booking.getCustomer().getId() == customerId) {
                    Flight newFlight = fbs.getFlightByID(newFlightId);
                    booking.setFlight(newFlight);
                    JOptionPane.showMessageDialog(this, "Booking updated successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            throw new Exception("No booking found for this customer");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cancelBookingDialog() {
        String customerIdStr = JOptionPane.showInputDialog(this, "Enter Customer ID:");
        if (customerIdStr == null || customerIdStr.trim().isEmpty()) {
            return;
        }
        try {
            int customerId = Integer.parseInt(customerIdStr);
            String flightIdStr = JOptionPane.showInputDialog(this, "Enter Flight ID:");
            int flightId = Integer.parseInt(flightIdStr);

            Booking bookingToRemove = null;
            for (Booking booking : fbs.getBookings()) {
                if (booking.getCustomer().getId() == customerId && booking.getFlight().getId() == flightId) {
                    bookingToRemove = booking;
                    break;
                }
            }

            if (bookingToRemove != null) {
                fbs.removeBooking(bookingToRemove);
                JOptionPane.showMessageDialog(this, "Booking cancelled successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                throw new Exception("No booking found for this customer and flight");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void displayFlights() {
        List<Flight> flightsList = fbs.getFlights();
        // headers for the table
        String[] columns = new String[]{"ID", "Flight No", "Origin", "Destination", "Departure Date"};

        Object[][] data = new Object[flightsList.size()][5];
        for (int i = 0; i < flightsList.size(); i++) {
            Flight flight = flightsList.get(i);
            data[i][0] = flight.getId();
            data[i][1] = flight.getFlightNumber();
            data[i][2] = flight.getOrigin();
            data[i][3] = flight.getDestination();
            data[i][4] = flight.getDepartureDate();
        }

        JTable table = new JTable(data, columns);
        this.getContentPane().removeAll();
        this.getContentPane().add(new JScrollPane(table));
        this.revalidate();
    }

    public void displayBookings() {
        List<Booking> bookingsList = fbs.getBookings();
        String[] columns = new String[]{"Customer ID", "Customer Name", "Flight ID", "Flight No", "Origin", "Destination", "Booking Date"};

        Object[][] data = new Object[bookingsList.size()][7];
        for (int i = 0; i < bookingsList.size(); i++) {
            Booking booking = bookingsList.get(i);
            data[i][0] = booking.getCustomer().getId();
            data[i][1] = booking.getCustomer().getName();
            data[i][2] = booking.getFlight().getId();
            data[i][3] = booking.getFlight().getFlightNumber();
            data[i][4] = booking.getFlight().getOrigin();
            data[i][5] = booking.getFlight().getDestination();
            data[i][6] = booking.getBookingDate();
        }

        JTable table = new JTable(data, columns);
        this.getContentPane().removeAll();
        this.getContentPane().add(new JScrollPane(table));
        this.revalidate();
    }

    private void saveData() {
        try {
            FlightBookingSystemData.store(fbs);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Failed to save data: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
