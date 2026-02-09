# QUICK START GUIDE - Flight Booking System

## ✅ Application is Complete and Ready to Use

### Step 1: Build (if not already built)
```
Double-click: build.bat
```
This will compile all source files into the bin/ directory.

### Step 2: Run

**Option A - Console Version (Recommended for Testing):**
```
Double-click: run.bat
```

**Option B - From Command Line:**
```
java -cp bin\bcu bcu.cmp5332.bookingsystem.main.Main
```

**Option C - GUI Version:**
1. Run the console version
2. Type: `loadgui` and press Enter

### Step 3: Try These Commands

**View Available Flights:**
```
> listflights
```

**View Available Customers:**
```
> listcustomers
```

**Add a New Customer:**
```
> addcustomer
  Name: John Doe
  Phone: 07700123456
```

**Add a Booking:**
```
> addbooking 1 1
```
(Books Customer #1 on Flight #1)

**Get Help:**
```
> help
```

**Launch GUI:**
```
> loadgui
```

**Exit:**
```
> exit
```

---

## GUI Menu Overview

### Admin Menu
- **Exit** - Save and exit application

### Flights Menu
- **View** - Display all flights in table
- **Add** - Add a new flight
- **Delete** - Remove a flight

### Bookings Menu
- **View** - Display all bookings in table
- **Issue** - Create a new booking
- **Update** - Modify an existing booking
- **Cancel** - Cancel a booking

### Customers Menu
- **View** - Display all customers in table
- **Add** - Add a new customer
- **Delete** - Remove a customer

---

## Sample Data Included

**Flight #1:**
- Number: LH2560
- Route: Birmingham → Munich
- Date: 2022-11-25

**Customers:**
1. Abdel-Rahman Tawil (07555555555)
2. Kostas Vlachos (07596454545)

**Booking:**
- Customer #1 on Flight #1 (2024-11-11)

---

## File Locations

- **Source Code:** `src/bcu/cmp5332/bookingsystem/`
- **Compiled Classes:** `bin/bcu/cmp5332/bookingsystem/`
- **Data Files:** `resources/data/`
  - flights.txt
  - customers.txt
  - bookings.txt

---

## Features at a Glance

✅ View/Add/Delete Flights
✅ View/Add/Delete Customers
✅ Create/Update/Cancel Bookings
✅ Persistent Data Storage
✅ Console Interface
✅ Professional GUI
✅ Error Handling
✅ Input Validation

---

## Troubleshooting

**Q: build.bat doesn't work?**
A: Make sure Java is installed. Open Command Prompt and type: `java -version`

**Q: run.bat doesn't work?**
A: Run `build.bat` first to compile the code.

**Q: GUI doesn't appear?**
A: Type `loadgui` in the console version, or check Java Swing compatibility.

**Q: Data not saving?**
A: Ensure the `resources/data/` directory exists and is writable.

---

## What's Implemented

### Model Layer ✅
- Flight, Customer, Booking, FlightBookingSystem

### Data Access Layer ✅
- FlightDataManager, CustomerDataManager, BookingDataManager

### Command Layer ✅
- 12 Command implementations (Add, Show, List, Edit, Cancel)

### User Interface ✅
- Console Command Parser
- GUI with Menu Bar
- Dialog Windows for Input/Output

### Data Persistence ✅
- File-based storage
- Automatic loading/saving
- Data validation

---

## System Architecture

```
┌─────────────────────────────────────────┐
│        User Interface Layer             │
│  (Console & GUI - Main/AddWindow/etc)   │
└────────────────┬────────────────────────┘
                 │
┌────────────────▼────────────────────────┐
│      Command/Operation Layer            │
│  (Command Pattern Implementation)       │
└────────────────┬────────────────────────┘
                 │
┌────────────────▼────────────────────────┐
│       Business Logic Layer              │
│   (FlightBookingSystem Model)           │
└────────────────┬────────────────────────┘
                 │
┌────────────────▼────────────────────────┐
│     Data Access/Persistence Layer       │
│   (DataManager Implementations)         │
└────────────────┬────────────────────────┘
                 │
┌────────────────▼────────────────────────┐
│      Data Storage (Files)               │
│   (flights.txt, customers.txt, etc)     │
└─────────────────────────────────────────┘
```

---

## For Your College Submission

This project includes:

1. ✅ Complete Source Code (src/)
2. ✅ Compiled Binaries (bin/)
3. ✅ Sample Data (resources/)
4. ✅ Build Scripts (build.bat)
5. ✅ Run Scripts (run.bat)
6. ✅ Documentation (README.md)
7. ✅ Completion Report (COMPLETION_REPORT.md)

**Total Implementation:**
- 5 Model Classes
- 4 Data Manager Classes
- 12 Command Classes
- 5 GUI Window Classes
- 2 Main/Parser Classes
- All with Full Functionality and Error Handling

---

## Next Steps After Submission

The system is designed to be extensible. Future enhancements could include:
- Database support (MySQL/SQLite)
- Web interface
- Email notifications
- Advanced search/filtering
- Seat availability tracking
- User authentication

---

**Created:** February 2026
**Status:** COMPLETE ✅
**Ready to Use:** YES ✅

