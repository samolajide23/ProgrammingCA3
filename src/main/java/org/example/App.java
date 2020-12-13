package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    private static Scanner keyboard = new Scanner(System.in);
    public static void main( String[] args )
    {
        App app = new App();
        app.start();
    }

    public void start()
    {
        StudentDB students = new StudentDB();
        students.loadStudentFromFile();

        ComputerDB computers = new ComputerDB();
        computers.loadDesktopComputersFromFile();
        computers.loadLaptopComputersFromFile();
        computers.loadRaspberryPiComputersFromFile();

        BookingDB bookings = new BookingDB();
        bookings.loadBookingsFromFile();

        Menu.MainMenuLoop(students,computers,bookings);
        students.saveStudentsToFile();
        bookings.saveBookingsToFile();
    }

}
