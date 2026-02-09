# Flight Booking System

A complete Java application for managing flights, customers, and bookings with both console and GUI interfaces.

## Project Structure

```
FlightBookingSystem_Dist/
├── src/
│   └── bcu/cmp5332/bookingsystem/
│       ├── main/              # Main classes and command parser
│       │   ├── Main.java
│       │   ├── CommandParser.java
│       │   └── FlightBookingSystemException.java
│       ├── model/             # Data models
│       │   ├── Flight.java
│       │   ├── Customer.java
│       │   ├── Booking.java
│       │   └── FlightBookingSystem.java
│       ├── commands/          # Command pattern implementation
│       │   ├── Command.java (interface)
│       │   ├── AddFlight.java
│       │   ├── AddCustomer.java
│       │   ├── ShowFlight.java
│       │   ├── ShowCustomer.java
│       │   ├── ListFlights.java
│       │   ├── ListCustomers.java
│       │   ├── AddBooking.java
│       │   ├── EditBooking.java
│       │   ├── CancelBooking.java
│       │   ├── LoadGUI.java
│       │   └── Help.java
│       ├── data/              # Data persistence layer
│       │   ├── DataManager.java (interface)
│       │   ├── FlightDataManager.java
│       │   ├── CustomerDataManager.java
│       │   ├── BookingDataManager.java
│       │   └── FlightBookingSystemData.java
│       └── gui/               # GUI components
│           ├── MainWindow.java
│           ├── AddFlightWindow.java
│           ├── AddCustomerWindow.java
│           ├── AddBookingWindow.java
│           ├── ViewCustomersWindow.java
│           └── ViewBookingsWindow.java
├── resources/data/            # Data storage files
│   ├── flights.txt
│   ├── customers.txt
│   └── bookings.txt
├── bin/                       # Compiled classes (auto-generated)
└── build.bat                  # Build script

```

## Features

### Console Interface
- View all flights and customers
- Add new flights and customers
- Create, update, and cancel bookings
- Show detailed information about flights and customers

### GUI Interface
- Professional Swing-based interface
- Menu-driven operations
- Table views for displaying data
- Dialog windows for adding/editing data
- Data persistence with automatic saving

### Data Persistence
- File-based storage (txt files with :: separator)
- Automatic loading on startup
- Automatic saving after operations
- Support for flights, customers, and bookings

## Commands (Console)

```
listflights                               Print all flights
listcustomers                             Print all customers
addflight                                 Add a new flight
addcustomer                               Add a new customer
showflight [flight id]                    Show flight details
showcustomer [customer id]                Show customer details
addbooking [customer id] [flight id]      Create a new booking
editbooking [customer id] [flight id]     Update a booking
cancelbooking [customer id] [flight id]   Cancel a booking
loadgui                                   Load GUI version
help                                      Show help message
exit                                      Exit the program
```

## How to Build

### Option 1: Using Build Script (Windows)
```
build.bat
```

### Option 2: Manual Compilation
```bash
# Navigate to project directory
cd FlightBookingSystem_Dist

# Compile in order
javac -d bin\bcu -cp bin\bcu src\bcu\cmp5332\bookingsystem\main\FlightBookingSystemException.java
javac -d bin\bcu -cp bin\bcu src\bcu\cmp5332\bookingsystem\model\*.java
javac -d bin\bcu -cp bin\bcu src\bcu\cmp5332\bookingsystem\data\*.java
javac -d bin\bcu -cp bin\bcu src\bcu\cmp5332\bookingsystem\commands\*.java
javac -d bin\bcu -cp bin\bcu src\bcu\cmp5332\bookingsystem\gui\*.java
javac -d bin\bcu -cp bin\bcu src\bcu\cmp5332\bookingsystem\main\*.java
```

## How to Run

### Console Version
```bash
java -cp bin\bcu bcu.cmp5332.bookingsystem.main.Main
```

### GUI Version
Option 1: Through console
```bash
java -cp bin\bcu bcu.cmp5332.bookingsystem.main.Main
> loadgui
```

Option 2: Direct from IDE
- Uncomment main() method in MainWindow.java
- Run MainWindow directly

## Sample Data

Default sample data is included in resources/data/:

**Flights:**
- Flight #1: LH2560, Birmingham -> Munich, 2022-11-25

**Customers:**
- Customer #1: Abdel-Rahman Tawil, 07555555555
- Customer #2: Kostas Vlachos, 07596454545

**Bookings:**
- Booking: Customer #1 -> Flight #1, booked on 2024-11-11

## Architecture

### Design Patterns Used
1. **Command Pattern** - For command execution
2. **MVC Pattern** - For GUI structure
3. **Data Access Object Pattern** - For data persistence
4. **Singleton Pattern** - For FlightBookingSystem data store

### Class Responsibilities

**Model Classes:**
- `Flight`: Stores flight information and passenger list
- `Customer`: Stores customer information and booking list
- `Booking`: Represents a customer booking on a flight
- `FlightBookingSystem`: Central data store and business logic

**Command Classes:**
- Implement the Command interface
- Execute specific operations on FlightBookingSystem
- Used by both console and GUI

**Data Managers:**
- Load/store data from/to text files
- Implement DataManager interface
- Called during system startup and shutdown

**GUI Components:**
- `MainWindow`: Main application window with menu bar
- Window classes: Handle specific operations (Add, View, Update)
- Display data in table format with JScrollPane

## Data File Format

### flights.txt
```
id::flightNumber::origin::destination::departureDate::
```

### customers.txt
```
id::name::phone::
```

### bookings.txt
```
customerId::flightId::bookingDate::
```

## Features Implemented

✅ Complete model classes with full getters/setters
✅ Data persistence (flights, customers, bookings)
✅ Console interface with command parser
✅ GUI with menu-driven interface
✅ Flight management (view, add, delete)
✅ Customer management (view, add, delete)
✅ Booking management (issue, view, update, cancel)
✅ Data validation and error handling
✅ Automatic data saving after operations
✅ Professional UI with Swing components

## System Requirements
- Java 8 or higher
- 100MB free disk space

## Notes
- All data is stored in plain text files in resources/data/
- Changes are automatically saved when exiting or after operations
- The system date is fixed at 2024-11-11 for consistency
- Empty bookings file can be initialized by the system on first run

## Troubleshooting

**Problem:** "File not found" error
- **Solution:** Ensure resources/data/ directory exists with txt files

**Problem:** Classes not found during compilation
- **Solution:** Compile in the correct order (Exception -> Model -> Data -> Commands -> GUI -> Main)

**Problem:** GUI doesn't appear
- **Solution:** Check if UIManager.setLookAndFeel() is working on your system

## Future Enhancements
- Database support (SQL)
- Search/filter functionality
- Seat availability tracking
- Email notifications
- Advanced reporting
- User authentication

---
**Version:** 1.0
**Last Updated:** February 2026

