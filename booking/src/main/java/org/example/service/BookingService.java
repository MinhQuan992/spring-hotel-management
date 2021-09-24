package org.example.service;

import lombok.AllArgsConstructor;
import org.example.model.Booking;
import org.example.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Booking getBookingById(Long id) {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("This id does not exist"));
    }

    public Booking addNewBooking(Long roomId, String customerName) {
        List<Long> bookedRooms = bookingRepository.findBookedRooms();
        if (bookedRooms.contains(roomId)) {
            throw new IllegalStateException("This room is being booked");
        }
        LocalDate today = LocalDate.now();
        Booking booking = new Booking(roomId, customerName, today, null, null);
        return bookingRepository.save(booking);
    }

    public Booking updateCheckinDate(Long id, int year, int month, int day) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("This id does not exist"));
        LocalDate checkinDate = LocalDate.of(year, month, day);
        booking.setCheckinDate(checkinDate);
        return bookingRepository.save(booking);
    }

    public Booking updateCheckoutDate(Long id, int year, int month, int day) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("This id does not exist"));
        LocalDate checkoutDate = LocalDate.of(year, month, day);
        booking.setCheckoutDate(checkoutDate);
        return bookingRepository.save(booking);
    }

    public Booking deleteBookingById(Long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("This id does not exist"));
        bookingRepository.deleteById(id);
        return booking;
    }
}
