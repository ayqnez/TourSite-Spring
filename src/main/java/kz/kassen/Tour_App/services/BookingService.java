package kz.kassen.Tour_App.services;

import kz.kassen.Tour_App.models.BookingModel;
import kz.kassen.Tour_App.repo.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<BookingModel> getAllBookings() {
        return bookingRepository.findAll();
    }

    public void saveBooking(BookingModel bookingModel) {
        bookingRepository.save(bookingModel);
    }

    public void deleteBooking(BookingModel bookingModel) {
        bookingRepository.delete(bookingModel);
    }
}
