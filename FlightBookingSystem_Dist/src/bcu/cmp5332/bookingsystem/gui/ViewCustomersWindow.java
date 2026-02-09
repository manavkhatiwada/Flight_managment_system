package bcu.cmp5332.bookingsystem.gui;

import bcu.cmp5332.bookingsystem.model.Customer;
import bcu.cmp5332.bookingsystem.model.FlightBookingSystem;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;

public class ViewCustomersWindow extends JFrame {

    private MainWindow mw;

    public ViewCustomersWindow(MainWindow mw) {
        this.mw = mw;
        initialize();
    }

    private void initialize() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {

        }

        setTitle("View Customers");
        setSize(600, 400);

        displayCustomers();

        setLocationRelativeTo(mw);
        setVisible(true);
    }

    public void displayCustomers() {
        FlightBookingSystem fbs = mw.getFlightBookingSystem();
        List<Customer> customersList = fbs.getCustomers();

        String[] columns = new String[]{"ID", "Name", "Phone", "Bookings"};
        Object[][] data = new Object[customersList.size()][4];

        for (int i = 0; i < customersList.size(); i++) {
            Customer customer = customersList.get(i);
            data[i][0] = customer.getId();
            data[i][1] = customer.getName();
            data[i][2] = customer.getPhone();
            data[i][3] = customer.getBookings().size();
        }

        JTable table = new JTable(data, columns);
        this.getContentPane().removeAll();
        this.getContentPane().add(new JScrollPane(table));
        this.revalidate();
    }
}

