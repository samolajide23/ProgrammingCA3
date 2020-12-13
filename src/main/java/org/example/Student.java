package org.example;

import java.util.ArrayList;


public class Student
{

    private String name;
    private String id;
    private String email;
    private String telephone;
    private ArrayList<String> computersOnLoan;

    public Student(String name, String id, String email, String telephone, ArrayList<String> computersOnLoan) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.telephone = telephone;
        this.computersOnLoan = computersOnLoan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public ArrayList<String> getComputersOnLoan() {
        return computersOnLoan;
    }

    public void setComputersOnLoan(ArrayList<String> computersOnLoan) {
        this.computersOnLoan = computersOnLoan;
    }

    @Override
    public String toString() {
        return  "\nId: '" +Colours.PURPLE + id + Colours.RESET + '\'' +
                "\n{Name: '" + name + '\'' +
                ",  Email: '" + email + '\'' +
                ",  Telephone: '" + telephone + '\'' +
                ",  ComputersOnLoan: " + computersOnLoan +
                "}";
    }
}

