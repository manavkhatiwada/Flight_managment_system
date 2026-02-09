# INTELLIJ CONFIGURATION GUIDE

## Problem
When running the application from IntelliJ, you get:
```
FileNotFoundException: .\resources\data\flights.txt
```

## Solution

The issue is that IntelliJ's working directory is not set correctly. Here's how to fix it:

### Method 1: Set Working Directory in Run Configuration (RECOMMENDED)

1. **Open Run Configuration:**
   - Click on Run menu → Edit Configurations
   - Or click the run configuration dropdown and select "Edit Configurations"

2. **Find your Main configuration:**
   - Look for "Main" in the list on the left
   - If it doesn't exist, create a new configuration:
     - Click "+" → Application
     - Name: "Main"
     - Main class: `bcu.cmp5332.bookingsystem.main.Main`

3. **Set Working Directory:**
   - Find the "Working directory" field
   - Set it to: `D:\FlightBookingSystem_final\FlightBookingSystem_Dist`
   - Or click the folder icon and navigate to FlightBookingSystem_Dist

4. **Click OK**

5. **Run the application:**
   - Click Run → Run 'Main'
   - Or press Shift + F10

### Method 2: Configure Project Structure

1. **File → Project Structure**

2. **Go to "Project"**

3. **Set the Project SDK to JDK 25** (or your Java version)

4. **Go to "Modules"**

5. **Select your module and set:**
   - Sources: `src`
   - Resources: `resources`
   - Output path: `out/production/FlightBookingSystem_Dist`

6. **Click OK**

7. **Build → Rebuild Project**

### Method 3: Copy Resources to Output Directory

The resources folder has been copied to multiple locations:
- `D:\FlightBookingSystem_final\resources\` ✅
- `D:\FlightBookingSystem_final\FlightBookingSystem_Dist\resources\` ✅

IntelliJ will now find the resources from either location.

## After Configuration

Run the application:
1. Right-click on `Main.java`
2. Select "Run 'Main.main()'"
3. OR press Shift + F10

The application should now start successfully!

## If Still Having Issues

1. **Close IntelliJ completely**

2. **Delete the out folder:**
   ```
   Delete: D:\FlightBookingSystem_final\out\
   ```

3. **Open IntelliJ again**

4. **Build → Rebuild Project**

5. **Run the application**

## Console Output Should Show

```
Flight Booking System
Enter 'help' to see a list of available commands.
>
```

## Using Command Line Instead

If you prefer to use command line:

```bash
cd D:\FlightBookingSystem_Dist
java -cp bin\bcu bcu.cmp5332.bookingsystem.main.Main
```

This will always work because the working directory is correct.

## Summary

✅ Working directory is now correctly set to FlightBookingSystem_Dist
✅ Resources folder copied to multiple locations
✅ Data managers updated to search for resources in multiple paths
✅ Application will run from IntelliJ or command line

Any questions? Check the README.md or QUICK_START.md files.

