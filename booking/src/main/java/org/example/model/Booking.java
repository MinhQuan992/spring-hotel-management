package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long roomId;
    private String customerName;
    private LocalDate bookingDate;
    private LocalDate checkinDate;
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
