package org.example;

public class Student {

    private String studentId;
    private String bookingId;
    private String bookingDateAndTime;
    private String returnDateAndTime;
    private String computerType;
    private String computerAssetTag;

    public Student(String studentId, String bookingId, String bookingDateAndTime, String returnDateAndTime, String computerType, String computerAssetTag) {
        this.studentId = studentId;
        this.bookingId = bookingId;
        this.bookingDateAndTime = bookingDateAndTime;
        this.returnDateAndTime = returnDateAndTime;
        this.computerType = computerType;
        this.computerAssetTag = computerAssetTag;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingDateAndTime() {
        return bookingDateAndTime;
    }

    public void setBookingDateAndTime(String bookingDateAndTime) {
        this.bookingDateAndTime = bookingDateAndTime;
    }

    public String getReturnDateAndTime() {
        return returnDateAndTime;
    }

    public void setReturnDateAndTime(String returnDateAndTime) {
        this.returnDateAndTime = returnDateAndTime;
    }

    public String getComputerType() {
        return computerType;
    }

    public void setComputerType(String computerType) {
        this.computerType = computerType;
    }

    public String getComputerAssetTag() {
        return computerAssetTag;
    }

    public void setComputerAssetTag(String computerAssetTag) {
        this.computerAssetTag = computerAssetTag;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

}
