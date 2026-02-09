# QUICK COPY-PASTE COMMANDS

## To Run From Command Line

### Windows Command Prompt
```
cd D:\FlightBookingSystem_final\FlightBookingSystem_Dist
java -cp bin\bcu bcu.cmp5332.bookingsystem.main.Main
```

### Windows PowerShell
```powershell
cd D:\FlightBookingSystem_final\FlightBookingSystem_Dist
java -cp bin\bcu bcu.cmp5332.bookingsystem.main.Main
```

### Linux/Mac
```bash
cd ~/D/FlightBookingSystem_final/FlightBookingSystem_Dist
java -cp bin/bcu bcu.cmp5332.bookingsystem.main.Main
```

---

## To Compile From Command Line

### All at Once
```bash
cd D:\FlightBookingSystem_final\FlightBookingSystem_Dist
javac -d bin\bcu src\bcu\cmp5332\bookingsystem\main\FlightBookingSystemException.java src\bcu\cmp5332\bookingsystem\model\*.java src\bcu\cmp5332\bookingsystem\data\*.java src\bcu\cmp5332\bookingsystem\commands\*.java src\bcu\cmp5332\bookingsystem\main\*.java src\bcu\cmp5332\bookingsystem\gui\*.java
```

### Then Run
```bash
java -cp bin\bcu bcu.cmp5332.bookingsystem.main.Main
```

---

## Sample Commands to Try

Once the application is running, try these commands:

```
> help
> listflights
> listcustomers
> showflight 1
> showcustomer 1
> addbooking 1 1
> loadgui
> exit
```

---

## From IntelliJ

1. Right-click on `Main.java`
2. Select "Run 'Main.main()'"
3. Or press Shift + F10

---

## Using Batch Files (Windows Only)

```
cd D:\FlightBookingSystem_final\FlightBookingSystem_Dist
build.bat
run.bat
```

---

## Most Common Issues & Fixes

### Issue: "Class not found"
Fix:
```
cd D:\FlightBookingSystem_final\FlightBookingSystem_Dist
```
Make sure you're in the correct directory!

### Issue: "FileNotFoundException"
This has been fixed! The ResourcePath utility will find the files.

### Issue: Nothing happens
Try:
```
java -cp bin\bcu -version
```
Make sure Java is installed.

---

That's it! Pick any method above and run!

