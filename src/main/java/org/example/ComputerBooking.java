package org.example;

public class ComputerBooking {
    private String name;
    private String id;
    private String email;
    private String telephone;
    private String computersOnLoan;

    public ComputerBooking(String name, String id, String email, String telephone, String computersOnLoan) {
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

    public String getComputersOnLoan() {
        return computersOnLoan;
    }

    public void setComputersOnLoan(String computersOnLoan) {
        this.computersOnLoan = computersOnLoan;
    }
}