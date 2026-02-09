@echo off
REM Flight Booking System Run Script

echo ========================================
echo Flight Booking System - Console Version
echo ========================================
echo.
echo Running application...
echo.

cd /d "%~dp0"

java -cp bin\bcu bcu.cmp5332.bookingsystem.main.Main

pause

