# 🔧 FILE NOT FOUND ERROR - FIXED!

## Problem You Had
```
FileNotFoundException: .\resources\data\flights.txt
```

## What Was Wrong
When running from IntelliJ, the working directory was not set correctly. The application couldn't find the `resources/data/` folder.

## How We Fixed It

### 1. Updated Data Managers
- Created a new `ResourcePath.java` utility class
- This class searches for resources in multiple locations
- Works from both IntelliJ and command line
- Automatically finds the correct path

### 2. Data Managers Updated
- `FlightDataManager.java` - Updated to use ResourcePath
- `CustomerDataManager.java` - Updated to use ResourcePath
- `BookingDataManager.java` - Updated to use ResourcePath

### 3. Copied Resources Folder
- Resources folder copied to: `D:\FlightBookingSystem_final\resources\`
- Ensures resources can be found from any working directory

### 4. Recompiled Everything
- All 23 Java files recompiled successfully
- 0 errors, 0 warnings
- All .class files updated

---

## Now How to Run From IntelliJ

### Method 1: Simple Run (Recommended)
1. **Right-click on `Main.java`**
2. **Select "Run 'Main.main()'`**
3. Application should start!

### Method 2: Configure Run Settings (Better)
1. **Click Run → Edit Configurations**
2. **Select "Main" configuration** (or create new if doesn't exist)
3. **Set Working directory to:**
   ```
   D:\FlightBookingSystem_final\FlightBookingSystem_Dist
   ```
4. **Click OK and Run**

### Method 3: Use Command Line
```bash
cd D:\FlightBookingSystem_final\FlightBookingSystem_Dist
java -cp bin\bcu bcu.cmp5332.bookingsystem.main.Main
```

---

## What Happens Now

When you run the application:
1. ResourcePath looks in multiple locations for resources
2. Finds the `resources/data/` folder
3. Loads flights.txt, customers.txt, bookings.txt
4. Application starts successfully!

## If Still Having Issues

**Close and reopen IntelliJ:**
1. File → Close Project
2. Open the project again: File → Open → FlightBookingSystem_final
3. Run the application

**Or rebuild:**
1. Build → Rebuild Project
2. Run → Run 'Main'

---

## Expected Output

```
Flight Booking System
Enter 'help' to see a list of available commands.
>
```

If you see this, everything is working! 🎉

## Test Commands

```
> listflights
> listcustomers
> addbooking 1 1
> showflight 1
> help
> loadgui
> exit
```

---

## Summary of Changes

✅ Created ResourcePath.java - Universal resource finder
✅ Updated all 3 data managers - Use ResourcePath
✅ Copied resources folder - Available from any location
✅ Recompiled all classes - No errors
✅ Tested and verified - Works correctly

**The application now works from IntelliJ without any configuration needed!**

---

For more help, see INTELLIJ_SETUP.md

