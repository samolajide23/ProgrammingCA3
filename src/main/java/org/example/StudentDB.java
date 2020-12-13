package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class StudentDB {
    private ArrayList<Student> students;
    private static Scanner keyboard = new Scanner(System.in);

    public StudentDB() {
        this.students = new ArrayList<>();
    }

    public void loadStudentFromFile() {
        try (Scanner studentsFile = new Scanner(new BufferedReader(new FileReader("students.txt")))) {
            String input;
            while (studentsFile.hasNextLine()) {
                input = studentsFile.nextLine();
                String[] data = input.split(",");
                String name = data[0];
                String id = data[1];
                String email = data[2];
                String telephone = data[3];
                ArrayList<String> computersOnLoan = new ArrayList<>();
                for (int i = 4; i < data.length ; i++) {
                    computersOnLoan.add(data[i]);
                }

                Student readInStudent = new Student(name,id,email,telephone,computersOnLoan);
                this.students.add(readInStudent);
            }
        } catch (FileNotFoundException fne) {
            System.out.println(Colours.PURPLE + "Could not load students." + "If this is the first time you are running the program this is fine." + Colours.RESET);
        }
    }
    public void saveStudentsToFile(){
        try (BufferedWriter studentsFile = new BufferedWriter(new FileWriter("students.txt"))) {
            for (Student student : students) {
                studentsFile.write(student.getName() + "," + student.getId() + "," + student.getEmail() + "," + student.getTelephone() + "," + student.getComputersOnLoan());
                studentsFile.write("\n");
            }
        } catch (IOException ioe) {
            System.out.println(Colours.PURPLE + "Could not save students." + Colours.RESET);
        }
    }

    @Override
    public String toString(){
        return "StudentDB{" +
                "students=" + students +
                '}';
    }

    //1
    public void addStudent() {
        String name = enterField("name");
        String id = enterField("Id");
        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println(Colours.RED + "Student with Id already exists" + Colours.RESET);
                return;
            }
        }
        String email = enterField("email");
        String telephone = enterField("telephone");
        ArrayList<String> computersOnLoan = new ArrayList<>();
        System.out.println("How many computers.txt did the student loan");

        int studentLoans = 0;
        boolean exit = false;
        while(!exit){
        try {
            exit = true;
            System.out.print("Enter your choice: ");
            studentLoans = Integer.parseInt(keyboard.nextLine());
            if (studentLoans == 0) {
            } else if (studentLoans < 1 || studentLoans > 3) {
                System.out.println("Invalid quantity. Please try again.");
                exit = false;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid quantity. Please try again.");
            exit = false;
        }

    }
        for(int i = 0; i < studentLoans; i++){
            System.out.println("Input asset Tag of computer " + i + 1);
            String computerOnLoan = keyboard.nextLine();
            computersOnLoan.add(computerOnLoan);
        }

        students.add(new Student(name,id,email,telephone,computersOnLoan));
    }
    private String enterField(String field){
        System.out.println("Enter Student " + field + ":> ");
        return keyboard.nextLine();
    }

    //2
    public void editStudent(){
        System.out.println("Enter ID of Student:");
        String studentID = keyboard.nextLine();
        for(Student student : students) {
            if (student.getId().equals(studentID)) {
        Student students = filterStudent(studentID);
        System.out.println(students);

        System.out.println("1 to edit Email (" + Colours.PURPLE + "Any other key will result in no edit" + Colours.RESET +")");
        try{ if(Integer.parseInt(keyboard.nextLine()) == 1) {
            System.out.println("Enter New Email");
            students.setEmail(keyboard.nextLine());
        }}catch(NumberFormatException e) {
        }

        System.out.println("1 to edit Telephone (" + Colours.PURPLE + "Any other key will result in no edit" + Colours.RESET +")");
        try{ if(Integer.parseInt(keyboard.nextLine()) == 1) {
            System.out.println("Enter New Telephone");
            students.setTelephone(keyboard.nextLine());
        }}catch (NumberFormatException e){
        }

        System.out.println("1 to edit Computers they have on Loan (" + Colours.PURPLE + "Any other key will result in no edit" + Colours.RESET +")");
        try{ if(Integer.parseInt(keyboard.nextLine()) == 1) {
            ArrayList<String> computersOnLoan = new ArrayList<>();
            System.out.println("How many computers.txt did the student loan");

            int studentLoans = 0;
            boolean exit = false;
            while(!exit)
            try{
                exit =true;
                System.out.print("Enter your choice: ");
                studentLoans = Integer.parseInt(keyboard.nextLine());
                if(studentLoans == 0){
                }
                else if (studentLoans < 1 || studentLoans > 3) {
                    System.out.println("Invalid quantity. Please try again.");
                    exit = false;
                }
            } catch (NumberFormatException e){
                System.out.println("Invalid quantity. Please try again.");
                exit = false;
            }

            for (int i = 0; i < studentLoans; i++) {
                System.out.println("Input asset Tag of computer" + i + 1);
                computersOnLoan.add(keyboard.nextLine());
            }
        }}catch (NumberFormatException e){
        }

        System.out.println(students);

    }
}
            System.out.println(Colours.RED + "Student with Id doesn't exists" + Colours.RESET);
    }

    //3
    public void deleteStudent() {
            System.out.println("Enter Id to delete:> ");
            String id = keyboard.nextLine();
            Student studentToRemove = filterStudent(id);

        for(Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println("(" + studentToRemove.getName() + ")"+ studentToRemove.getId() + " removed from the system");
                students.remove(filterStudent(id));
                return;
            }
        }
            System.out.println(Colours.RED + "Student with Id doesn't exists" + Colours.RESET);
    }

    //4
    public void printStudent() {
        System.out.println("Enter ID of Student:");
        String id = keyboard.nextLine();

        for (Student student : students) {

            if (student.getId().equals(id)) {

                System.out.println(filterStudent(id));

                return;
            }
        }
        System.out.println(Colours.RED + "Student with Id doesn't exists" + Colours.RESET);

    }

    //5
    public void printAllStudents(){
        System.out.println(students);
    }

    private Student filterStudent(String id){
        for(Student student : students)
        {
            if(student.getId().equals(id))
            {
                return student;
            }
        }
        return null;
    }

}
