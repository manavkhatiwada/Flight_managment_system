package bcu.cmp5332.bookingsystem.gui;

import bcu.cmp5332.bookingsystem.model.Booking;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

public class ViewBookingsWindow extends JFrame {

    private MainWindow mw;

    public ViewBookingsWindow(MainWindow mw) {
        this.mw = mw;
        initialize();
    }

    private void initialize() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {

        }

        setTitle("View Bookings");
        setSize(700, 400);

        displayBookings();

        setLocationRelativeTo(mw);
        setVisible(true);
    }

    public void displayBookings() {
        FlightBookingSystem fbs = mw.getFlightBookingSystem();
        List<Booking> bookingsList = fbs.getBookings();

        String[] columns = new String[]{"Customer ID", "Customer Name", "Flight ID", "Flight Number", "Origin", "Destination", "Booking Date"};
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
}

