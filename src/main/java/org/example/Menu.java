package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    private static Scanner keyboard = new Scanner(System.in);

    public static void MainMenuLoop(StudentDB students, ComputerDB computers,BookingDB bookings){
        boolean loop = true;
        MainMenu menuOption;
        int option;
        while(loop)
        {
            printMainMenu();
            try
            {
                option = getMainMenuInput();
                menuOption = MainMenu.values()[option];
                switch(menuOption)
                {
                    case QUIT_APPLICATION:
                        loop = false;
                        break;
                    case DISPLAY_STUDENT_MENU:
                        StudentMainMenuLoop(students);
                        break;
                    case DISPLAY_BOOKING_MENU:
                        BookingMainMenuLoop(students, computers,bookings);
                        break;
                }
            }
            catch(InputMismatchException ime)
            {
                System.out.println(Colours.RED + "Please enter a valid option" + Colours.RESET);
            }
        }
    }
    public static void printMainMenu(){
        System.out.println("\n Options to select:");
        for(int i=0; i < MainMenu.values().length;i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + MainMenu.values()[i].toString() + Colours.RESET);
        }
        System.out.println("Enter a number to select option (enter 0 to cancel):>");
    }
    public static int getMainMenuInput(){
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice > 2) {
            try {
                choice = Integer.parseInt(keyboard.nextLine());
                if (choice < 0 || choice > 2) {
                    System.out.println("Invalid selection. Please try again.");

                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Please try again.");
            }
        }
        return choice;
    }

    public static void StudentMainMenuLoop(StudentDB students){
        boolean loop = true;
        studentMainMenu menuOption;
        int option;
        while(loop)
        {
            printStudentMainMenu();
            try
            {
                option = getStudentMenuInput();
                menuOption = studentMainMenu.values()[option];
                switch(menuOption)
                {
                    case QUIT_STUDENT_MENU:
                        loop = false;
                        break;
                    case ADD_STUDENT:
                        students.addStudent();
                        break;
                    case EDIT_STUDENT:
                        students.editStudent();
                        break;
                    case DELETE_STUDENT:
                        students.deleteStudent();
                        break;
                    case PRINT_STUDENT:
                        students.printStudent();
                        break;
                    case PRINT_ALL_STUDENTS:;
                        students.printAllStudents();
                        break;
                }
            }
            catch(InputMismatchException ime)
            {
                System.out.println(Colours.RED + "Please enter a valid option" + Colours.RESET);
            }
        }
    }
    public static void printStudentMainMenu(){
        System.out.println("\n Options to select:");
        for(int i=0; i < studentMainMenu.values().length;i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + studentMainMenu.values()[i].toString() + Colours.RESET);
        }
        System.out.println("Enter a number to select option (enter 0 to cancel):>");
    }
    public static int getStudentMenuInput(){
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice > 5) {
            try {
                choice = Integer.parseInt(keyboard.nextLine());
                if (choice < 0 || choice > 5) {
                    System.out.println("Invalid selection. Please try again.");

                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Please try again.");
            }
        }
        return choice;
    }

    public static void BookingMainMenuLoop(StudentDB students, ComputerDB computers, BookingDB bookings){
        boolean loop = true;
        bookingMainMenu menuOption;
        int option;
        while(loop)
        {
            printBookingMainMenu();
            try
            {
                option = getBookingMenuInput();
                menuOption = bookingMainMenu.values()[option];
                switch(menuOption)
                {
                    case QUIT_BOOKING_MENU:
                        loop = false;
                        break;
                    case ADD_BOOKING:
                        bookings.addBooking();
                        break;
                    case EDIT_BOOKING:
                        bookings.editBooking();
                        break;
                    case DELETE_BOOKING:
                        bookings.deleteBooking();
                        break;
                    case PRINT_BOOKING_BY_BOOKING_ID:
                        bookings.printBooking();
                        break;
                    case PRINT_ALL_BOOKINGS:
                        bookings.printAllBookings();
                        break;
                    case PRINT_DATE_TIME_ORDER:
                        bookings.printDateTimeOrder();
                        break;
                    case RETURN_COMPUTER:
                        bookings.returnComputer();
                        break;
                    case AVERAGE_BOOKING_LENGTH:
                        bookings.averageBooking();
                        break;
                    case BOOKING_STATISTICS:
                        bookings.bookingStatistics();
                        break;
                }
            }
            catch(InputMismatchException ime)
            {
                System.out.println(Colours.RED + "Please enter a valid option" + Colours.RESET);
            }
        }
    }
    public static void printBookingMainMenu(){
        System.out.println("\n Options to select:");
        for(int i=0; i < bookingMainMenu.values().length;i++)
        {
            System.out.println("\t" + Colours.BLUE + i + ". " + bookingMainMenu.values()[i].toString() + Colours.RESET);
        }
        System.out.println("Enter a number to select option (enter 0 to cancel):>");
    }
    public static int getBookingMenuInput(){
        Scanner keyboard = new Scanner(System.in);
        int choice = -1;
        while (choice < 0 || choice > 9) {
            try {
                choice = Integer.parseInt(keyboard.nextLine());
                if (choice < 0 || choice > 9) {
                    System.out.println("Invalid selection. Please try again.");

                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection. Please try again.");
            }
        }
        return choice;
    }

}
