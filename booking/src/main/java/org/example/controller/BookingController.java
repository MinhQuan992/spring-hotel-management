package org.example.controller;

import lombok.AllArgsConstructor;
import org.example.model.Booking;
import org.example.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return new ResponseEntity<>(bookingService.addNewBooking(roomId, customerName), HttpStatus.CREATED);
    }

    @PutMapping("/checkin/{id}")
    public ResponseEntity<Booking> checkin(
            @PathVariable("id") Long id,
            @RequestParam("year") int year,
            @RequestParam("month") int month,
            @RequestParam("day") int day) {
        return new ResponseEntity<>(bookingService.updateCheckinDate(id, year, month, day), HttpStatus.OK);
    }

    @PutMapping("/checkout/{id}")
    public ResponseEntity<Booking> checkout(
            @PathVariable("id") Long id,
            @RequestParam("year") int year,
            @RequestParam("month") int month,
            @RequestParam("day") int day) {
        return new ResponseEntity<>(bookingService.updateCheckoutDate(id, year, month, day), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Booking> deleteBooking(@PathVariable("id") Long id) {
        return new ResponseEntity<>(bookingService.deleteBookingById(id), HttpStatus.OK);
    }
}
