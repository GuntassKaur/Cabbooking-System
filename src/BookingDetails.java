/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Guntass Kaur
 */
public class BookingDetails {

    public int bookingid;
    public int carid;
    public int priceperday;
    public String start_date;
    public String end_date;
    public int no_of_days;
    public int rent;
    public int security;
    public String name;
    public String mobile_no;
    public String address;
    public String email;
    public String payment_status;
    public String booking_status;

    public BookingDetails(int bookingid,int carid, int priceperday, String start_date, String end_date, int no_of_days,
            int rent, int security, String name, String mobile_no, String address, String email, String payment_status, String booking_status) {

        this.bookingid = bookingid;
        this.carid = carid;
        this.priceperday = priceperday;
        this.start_date = start_date;
        this.end_date = end_date;
        this.no_of_days = no_of_days;
        this.rent = rent;
        this.security = security;
        this.name = name;
        this.mobile_no = mobile_no;
        this.address = address;
        this.email = email;
        this.payment_status = payment_status;
        this.booking_status = booking_status;

    }
}