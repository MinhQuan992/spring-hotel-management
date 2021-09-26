package org.example.service;

import lombok.AllArgsConstructor;
import org.example.exception.NotFoundException;
import org.example.model.Booking;
import org.example.repository.BookingRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll(Sort.by("id"));
    }

    public Optional<Booking> getBookingById(Long id) {
        try {
            return bookingRepository.findById(id);
        } catch (Exception e) {
            throw new NotFoundException();
        }
    }

    public List<Long> getBookedRooms() {
        return bookingRepository.findBookedRooms();
    }

    public Booking addNewBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void deleteBookingById(Long id) {
        bookingRepository.deleteById(id);
    }
}
