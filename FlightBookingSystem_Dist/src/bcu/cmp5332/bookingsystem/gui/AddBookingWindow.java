package bcu.cmp5332.bookingsystem.gui;

import bcu.cmp5332.bookingsystem.commands.AddBooking;
import bcu.cmp5332.bookingsystem.commands.Command;
import bcu.cmp5332.bookingsystem.main.FlightBookingSystemException;
import bcu.cmp5332.bookingsystem.model.Customer;
import bcu.cmp5332.bookingsystem.model.Flight;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class AddBookingWindow extends JFrame implements ActionListener {

    private MainWindow mw;
    private JComboBox<String> customerCombo;
    private JComboBox<String> flightCombo;

    private JButton bookBtn = new JButton("Book");
    private JButton cancelBtn = new JButton("Cancel");

    public AddBookingWindow(MainWindow mw) {
        this.mw = mw;
        initialize();
    }

    private void initialize() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {

        }

        setTitle("Issue a New Booking");
        setSize(400, 180);

        // Populate customer combo
        java.util.List<Customer> customers = mw.getFlightBookingSystem().getCustomers();
        String[] customerNames = new String[customers.size()];
        for (int i = 0; i < customers.size(); i++) {
            Customer c = customers.get(i);
            customerNames[i] = "ID: " + c.getId() + " - " + c.getName();
        }
        customerCombo = new JComboBox<>(customerNames);

        // Populate flight combo
        java.util.List<Flight> flights = mw.getFlightBookingSystem().getFlights();
        String[] flightNames = new String[flights.size()];
        for (int i = 0; i < flights.size(); i++) {
            Flight f = flights.get(i);
            flightNames[i] = "ID: " + f.getId() + " - " + f.getFlightNumber() + " (" + f.getOrigin() + "-" + f.getDestination() + ")";
        }
        flightCombo = new JComboBox<>(flightNames);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(3, 2));
        topPanel.add(new JLabel("Select Customer : "));
        topPanel.add(customerCombo);
        topPanel.add(new JLabel("Select Flight : "));
        topPanel.add(flightCombo);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(1, 3));
        bottomPanel.add(new JLabel("     "));
        bottomPanel.add(bookBtn);
        bottomPanel.add(cancelBtn);

        bookBtn.addActionListener(this);
        cancelBtn.addActionListener(this);

        this.getContentPane().add(topPanel, BorderLayout.CENTER);
        this.getContentPane().add(bottomPanel, BorderLayout.SOUTH);
        setLocationRelativeTo(mw);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bookBtn) {
            addBooking();
        } else if (ae.getSource() == cancelBtn) {
            this.setVisible(false);
        }
    }

    private void addBooking() {
        try {
            java.util.List<Customer> customers = mw.getFlightBookingSystem().getCustomers();
            java.util.List<Flight> flights = mw.getFlightBookingSystem().getFlights();

            int customerIdx = customerCombo.getSelectedIndex();
            int flightIdx = flightCombo.getSelectedIndex();

            if (customerIdx < 0 || flightIdx < 0) {
                throw new FlightBookingSystemException("Please select both customer and flight");
            }

            int customerId = customers.get(customerIdx).getId();
            int flightId = flights.get(flightIdx).getId();

            Command addBooking = new AddBooking(customerId, flightId, LocalDate.now());
            addBooking.execute(mw.getFlightBookingSystem());
            JOptionPane.showMessageDialog(this, "Booking created successfully", "Success", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
        } catch (FlightBookingSystemException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

