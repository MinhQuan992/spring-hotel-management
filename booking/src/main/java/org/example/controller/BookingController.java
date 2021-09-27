package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.exception.NotFoundException;
import org.example.exception.RoomUnavailableException;
import org.example.model.Booking;
import org.example.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/booking")
@AllArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @GetMapping
    public ResponseEntity<Iterable<Booking>> getAllBookings() {
        return new ResponseEntity<>(bookingService.getAllBookings(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(bookingService.getBookingById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Booking> addNewBooking(
            @RequestParam("roomId") Long roomId,
            @RequestParam("customerName") String customerName) {
        LocalDate today = LocalDate.now();
        Booking booking = new Booking(roomId, customerName, today, null, null);
        return new ResponseEntity<>(bookingService.addNewBooking(booking), HttpStatus.CREATED);
    }

    @PutMapping("/checkin/{id}")
    public ResponseEntity<Booking> checkin(
            @PathVariable("id") Long id,
            @RequestParam("year") int year,
            @RequestParam("month") int month,
            @RequestParam("day") int day) {
        Booking booking = bookingService.getBookingById(id);
        LocalDate checkinDate = LocalDate.of(year, month, day);
        booking.setCheckinDate(checkinDate);
        return new ResponseEntity<>(bookingService.updateBooking(booking), HttpStatus.OK);
    }

    @PutMapping("/checkout/{id}")
    public ResponseEntity<Booking> checkout(
            @PathVariable("id") Long id,
            @RequestParam("year") int year,
            @RequestParam("month") int month,
            @RequestParam("day") int day) {
        Booking booking = bookingService.getBookingById(id);
        LocalDate checkoutDate = LocalDate.of(year, month, day);
        booking.setCheckoutDate(checkoutDate);
        return new ResponseEntity<>(bookingService.updateBooking(booking), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deleteBooking(@PathVariable("id") Long id) {
        Booking booking = bookingService.getBookingById(id);
        return new ResponseEntity<>(bookingService.deleteBooking(booking), HttpStatus.OK);
    }
}
