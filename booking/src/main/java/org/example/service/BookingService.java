package org.example.service;

import lombok.AllArgsConstructor;
import org.example.exception.NotFoundException;
import org.example.exception.RoomUnavailableException;
import org.example.model.Booking;
import org.example.repository.BookingRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll(Sort.by("id"));
    }

    public Booking getBookingById(Long id) {
        Optional<Booking> booking = bookingRepository.findById(id);
        if (booking.isEmpty()) {
            throw new NotFoundException();
        }
        return booking.get();
    }

    public Booking addNewBooking(Booking booking) {
        List<Booking> bookings = bookingRepository.findBookingsByCheckoutDateIsNull();
        List<Long> bookedRooms = new ArrayList<>();
        bookings.forEach((bookingInList) -> {
            bookedRooms.add(bookingInList.getRoomId());
        });
        if (bookedRooms.contains(booking.getRoomId())) {
            throw new RoomUnavailableException();
        }
        return bookingRepository.save(booking);
    }

    public Booking updateBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Map<String, String> deleteBooking(Booking booking) {
        bookingRepository.delete(booking);
        Map<String, String> result = new HashMap<>();
        result.put("Message: ", "Deleted Successfully");
        return result;
    }
}
