package org.example;

import java.io.*;
import java.time.*;
import java.util.*;

public class BookingDB extends ComputerDB {
    private ArrayList<Booking> bookings;
    private static Scanner keyboard = new Scanner(System.in);

    public BookingDB() {
        this.bookings = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "computerBookingDB{" +
                "computerBookings=" + bookings +
                '}';
    }

    public void loadBookingsFromFile() {
        try (Scanner playersFile = new Scanner(new BufferedReader(new FileReader("computerBooking.txt")))) {
            String input;
            while (playersFile.hasNextLine()) {
                input = playersFile.nextLine();
                String[] data = input.split(",");
                String bookingID = data[0];
                String bookingDateAndTime = data[1];
                String returnDateAndTime = data[2];
                String computerType = data[3];
                String computerAssetTag = data[4];
                String studentId = data[5];
                Booking readInPlayer = new Booking(bookingID, bookingDateAndTime, returnDateAndTime, computerType, computerAssetTag,studentId);
                this.bookings.add(readInPlayer);
            }
        } catch (FileNotFoundException fne) {
            System.out.println(Colours.PURPLE + "Could not load players." + "If this is the first time you are running the program this is fine." + Colours.RESET);
        }

    }

    public void saveBookingsToFile(){
        try (BufferedWriter studentsFile = new BufferedWriter(new FileWriter("computerBooking.txt"))) {
            for (Booking booking : bookings) {
                studentsFile.write(booking.getBookingId() + "," + booking.getBookingDateAndTime() + "," + booking.getReturnDateAndTime() + "," + booking.getComputerType() + "," + booking.getComputerAssetTag());
                studentsFile.write("\n");
            }
        } catch (IOException ioe) {
            System.out.println(Colours.PURPLE + "Could not save students." + Colours.RESET);
        }
    }

    //1
    public void addBooking() {
        String bookingId = enterField("id");
        for(Booking booking:bookings){
            if(booking.getBookingId().equals(bookingId)){
                System.out.println(Colours.RED + "Booking Id already exists" + Colours.RESET);
                return;
            }
        }
        String bookingDateAndTime = enterField("date and time (yyyy-MM-ddTHH:mm:ss)");
        String returnDateAndTime = enterField("return date and time (yyyy-MM-ddTHH:mm:ss)");
        String computerType = enterField("computer type");
        String computerAssetTag = enterField("computer asset tag");
        for(Booking booking:bookings){
            if(booking.getComputerAssetTag().equals(computerAssetTag)){
                System.out.println(Colours.RED + "Booking with Asset Tag already exists" + Colours.RESET);
                return;
            }
        }
        String studentId = enterField("student ID");
        bookings.add(new Booking(bookingId, bookingDateAndTime, returnDateAndTime, computerType, computerAssetTag,studentId));
    }
    private String enterField(String field) {
        System.out.println("Enter Booking " + field + ":> ");
        return keyboard.nextLine();
    }

    //2
    public void editBooking() {
        System.out.println("Enter Booking ID:");
        String bookingID = keyboard.nextLine();
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(bookingID)) {
                Booking bookings = filterBooking(bookingID);
                System.out.println(bookings);

                System.out.println("1 to edit Booked Date (" + Colours.PURPLE + "Any other key will result in no edit" + Colours.RESET + ")");
                try {
                    if (Integer.parseInt(keyboard.nextLine()) == 1) {
                        System.out.println("Enter New Booked Date");
                        try {
                            bookings.setBookingDateAndTime(LocalDateTime.parse(keyboard.nextLine()));
                        } catch (DateTimeException fne) {
                            System.out.println(Colours.RED + "Booked Date couldn't be changed(wrong format" + Colours.RESET + ")");
                        }
                    }
                } catch (NumberFormatException e) {
                }

                System.out.println("1 to edit Return Date (" + Colours.PURPLE + "Any other key will result in no edit" + Colours.RESET + ")");
                try {
                    if (Integer.parseInt(keyboard.nextLine()) == 1) {
                        System.out.println("Enter New Return Date");
                        try {
                            bookings.setReturnDateAndTime(LocalDateTime.parse(keyboard.nextLine()));
                        } catch (NumberFormatException fne) {
                            System.out.println(Colours.RED + "Return Date couldn't be changed(wrong format" + Colours.RESET + ")");

                        }
                    }
                } catch (NumberFormatException e) {
                }

                System.out.println("1 to edit Computer Type (" + Colours.PURPLE + "Any other key will result in no edit" + Colours.RESET + ")");
                try {
                    if (Integer.parseInt(keyboard.nextLine()) == 1) {
                        System.out.println("Enter New Computer Type");
                        bookings.setComputerType(keyboard.nextLine());
                    }
                } catch (NumberFormatException e) {
                }

                System.out.println("1 to edit Computer Asset Tag (" + Colours.PURPLE + "Any other key will result in no edit" + Colours.RESET + ")");
                try {
                    if (Integer.parseInt(keyboard.nextLine()) == 1) {
                        System.out.println("Enter New Computer Asset Tag");
                        bookings.setComputerAssetTag(keyboard.nextLine());
                    }
                } catch (NumberFormatException e) {
                }
                System.out.println(bookings);
            }
        }
        System.out.println(Colours.RED + "Booking with Asset Tag doesn't exists" + Colours.RESET);
    }

    //3
    public void deleteBooking() {
        System.out.println("Enter Booking Id to delete:> ");
        String id = keyboard.nextLine();
        Booking bookingToRemove = filterBooking(id);

        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(id)) {
                System.out.println("(" + bookingToRemove.getComputerAssetTag() + ")" + bookingToRemove.getBookingId() + " removed from the system");
                bookings.remove(filterBooking(id));
                return;
            }
        }
        System.out.println(Colours.RED + "Booking with Id doesn't exists" + Colours.RESET);
    }

    //4
    public void printBooking() {
        System.out.println("Enter Booking ID:");
        String id = keyboard.nextLine();
        for (Booking booking : bookings) {
            if (booking.getBookingId().equals(id)) {
                System.out.println(filterBooking(id));
                return;
            }
        }
        System.out.println(Colours.RED + "Student with Id doesn't exists" + Colours.RESET);

    }

    //5
    public void printAllBookings() {
        System.out.println(bookings);
    }

    //6
    public void printDateTimeOrder() {

        ArrayList<Booking> bookingsCopy = new ArrayList<>();
        //Copying The Arraylist
        for (int i = 0; i < bookings.size(); i++) {
            bookingsCopy.add(bookings.get(i));
        }

        //Sorting the Arraylist
        Comparator<Booking> byBookingDate = new Comparator<Booking>() {
            @Override
            public int compare(Booking o1, Booking o2) {
                if (o1.getBookingDateAndTime().isBefore(o2.getBookingDateAndTime())) return -1;
                else return 1;
            }
        };
        Collections.sort(bookingsCopy, byBookingDate);
        System.out.println(bookingsCopy);
        //Clearing the array to save space
        bookingsCopy.clear();
    }

    //7
    public void returnComputer() {
        System.out.println("Enter Computer Asset Key:");
        String ComputerAssetKey = keyboard.nextLine();

        for (Booking booking : bookings) {
            if (booking.getComputerAssetTag().equals(ComputerAssetKey)) {
                booking.setReturnDateAndTime(LocalDateTime.now());
                System.out.println(Colours.PURPLE + "Computer Returned to system" + Colours.RESET);
                return;
            }
        }
            System.out.println(Colours.RED + "Computer with Asset Key doesn't exists" + Colours.RESET);



    }

    //8
    public void averageBooking() {
        LocalDateTime start;
        LocalDateTime end;

        long difference = 0;
        long averageValue = 0;
        long sum = 0;
        long count = 0;

        if (bookings.size() > -1) {

            for (Booking booking : bookings) {

                start = booking.getBookingDateAndTime();
                end = booking.getReturnDateAndTime();
                if (end != null) {
                    difference = Duration.between(start, end).toMillis();
                    sum = difference + sum;
                    count++;
                }
            }
                averageValue = (sum / count);

                    long millisInDay = 1000 * 60 * 60 * 24;
                    long millisInHour = 1000 * 60 * 60;
                    long millisInMinute = 1000 * 60;
                    long millisInSecond = 1000;

                    long days = averageValue / millisInDay;   // integer division
                    long daysDivisionResidueMillis = averageValue - (days * millisInDay); // subtract days to get remaining hours

                    long hours = daysDivisionResidueMillis / millisInHour;
                    long hoursDivisionResidueMillis = daysDivisionResidueMillis - (hours * millisInHour);

                    long minutes = hoursDivisionResidueMillis / millisInMinute;
                    long minutesDivisionResidueMillis = hoursDivisionResidueMillis - (minutes * millisInMinute);

                    long seconds = minutesDivisionResidueMillis / millisInSecond;
                    long secondsDivisionResidueMillis = minutesDivisionResidueMillis - (seconds * millisInSecond);

                System.out.printf("Average length of bookings: ");
                    System.out.println(
                                    + days
                                    + " days. "
                                    + hours
                                    + " hours. "
                                    + minutes
                                    + " min. "
                                    + seconds
                                    + " sec. "
                                    + secondsDivisionResidueMillis
                                    + " millis.");

        }

    }

    //9
    public void bookingStatistics(){
        int desktopCount = 0;
        int laptopCount = 0;
        int raspberryPiCount = 0;

        for(Booking booking:bookings){
            if(booking.getComputerType().equals("Desktop"))
            {
                desktopCount++;
            }
        }

        for(Booking booking:bookings){
            if(booking.getComputerType().equals("Laptop"))
            {
                laptopCount++;
            }
        }

        for(Booking booking:bookings){
            if(booking.getComputerType().equals("Raspberry Pi"))
            {
                raspberryPiCount++;
            }
        }
        System.out.println("Number of Desktops booked: " + desktopCount);
        System.out.println("Number of Laptops booked:" + laptopCount);
        System.out.println("Number of Raspberry Pi booked:" + raspberryPiCount);
    }

    private Booking filterBooking(String id){
        for(Booking booking : bookings) {
            if (booking.getBookingId().equals(id)) {
                return booking;
            }
        }
        return null;
    }
}
