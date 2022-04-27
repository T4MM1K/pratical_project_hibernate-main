package model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Bookings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private int bookingId;
    private Date arrival;
    private Date checkout;
    private String status;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;

    @OneToOne
    @JoinColumn(name = "payment_id")
    private Payments payment;

    @OneToOne
    @JoinColumn(name = "room_number")
    private Rooms room;

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Date getArrival() {
        return arrival;
    }

    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }

    public Date getCheckout() {
        return checkout;
    }

    public void setCheckout(Date checkout) {
        this.checkout = checkout;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "bookingId=" + bookingId +
                ", arrival=" + arrival +
                ", checkout=" + checkout +
                ", status='" + status + '\'' +
                '}';
    }
}
