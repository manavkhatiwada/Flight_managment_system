@echo off
REM Flight Booking System Build Script
echo Building Flight Booking System...

cd /d "%~dp0"

REM Create bin directory if it doesn't exist
if not exist "bin\bcu" mkdir bin\bcu

REM Compile all source files
echo Compiling Exception class...
javac -d bin\bcu -cp bin\bcu src\bcu\cmp5332\bookingsystem\main\FlightBookingSystemException.java

echo Compiling Model classes...
javac -d bin\bcu -cp bin\bcu src\bcu\cmp5332\bookingsystem\model\*.java

echo Compiling Data Manager classes...
javac -d bin\bcu -cp bin\bcu src\bcu\cmp5332\bookingsystem\data\*.java

echo Compiling Command classes...
javac -d bin\bcu -cp bin\bcu src\bcu\cmp5332\bookingsystem\commands\*.java

echo Compiling GUI classes...
javac -d bin\bcu -cp bin\bcu src\bcu\cmp5332\bookingsystem\gui\*.java

echo Compiling Main classes...
javac -d bin\bcu -cp bin\bcu src\bcu\cmp5332\bookingsystem\main\*.java

echo.
echo Build completed successfully!
echo.
echo To run the application:
echo   Console: java -cp bin\bcu bcu.cmp5332.bookingsystem.main.Main
echo   GUI: Uncomment main() in MainWindow.java and run it
pause

