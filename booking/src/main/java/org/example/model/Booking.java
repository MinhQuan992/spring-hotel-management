package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "bookings")
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "room_id")
    private Long roomId;

    @Column(name = "customer_name")
    private String customerName;

    @Column(name = "booking_date")
    private LocalDate bookingDate;

    @Column(name = "checkin_date")
    private LocalDate checkinDate;

    @Column(name = "checkout_date")
    private LocalDate checkoutDate;

    public Booking(Long roomId, String customerName, LocalDate bookingDate, LocalDate checkinDate, LocalDate checkoutDate) {
        this.roomId = roomId;
        this.customerName = customerName;
        this.bookingDate = bookingDate;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
    }

    public Booking() {

    }
}
