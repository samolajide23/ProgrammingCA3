package org.example;


import java.time.LocalDateTime;

public class Booking{
    private String bookingId;
    private LocalDateTime bookingDateAndTime;
    private LocalDateTime returnDateAndTime;
    private String computerType;
    private String computerAssetTag;
    private String studentId;

    public Booking(String bookingId, String strBookingDateAndTime, String strReturnDateAndTime, String computerType, String computerAssetTag,String studentId) {
        this.bookingId = bookingId;
        this.bookingDateAndTime = LocalDateTime.parse(strBookingDateAndTime);
        if(!strReturnDateAndTime.isEmpty()) {
            this.returnDateAndTime = LocalDateTime.parse(strReturnDateAndTime);
        }
        this.computerType = computerType;
        this.computerAssetTag = computerAssetTag;
        this.studentId = studentId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public LocalDateTime getBookingDateAndTime() {
        return bookingDateAndTime;
    }

    public void setBookingDateAndTime(LocalDateTime bookingDateAndTime) {
        this.bookingDateAndTime = bookingDateAndTime;
    }

    public LocalDateTime getReturnDateAndTime() {
        return returnDateAndTime;
    }

    public void setReturnDateAndTime(LocalDateTime returnDateAndTime) {
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

    @Override
    public String toString() {
        return Colours.PURPLE + "\n\nBookings" + Colours.RESET + "{" +
                "bookingId='" + bookingId + '\'' +
                ", bookingDateAndTime=" + bookingDateAndTime +
                ", returnDateAndTime=" + returnDateAndTime +
                ", computerType='" + computerType + '\'' +
                ", computerAssetTag='" + computerAssetTag + '\'' +
                '}';
    }
}