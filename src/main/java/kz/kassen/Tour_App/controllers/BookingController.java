package kz.kassen.Tour_App.controllers;

import kz.kassen.Tour_App.models.BookingModel;
import kz.kassen.Tour_App.services.BookingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingController {
    private final BookingService bookingService;

    private BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping("/listBookings")
    public String listBookings(Model model) {
        List<BookingModel> bookings = bookingService.getAllBookings();
        model.addAttribute("bookings", bookings);
        return "bookings/listBookings";
    }

    @GetMapping("/addBooking")
    public String addBooking() {
        return "bookings/addBooking";
    }

    @PostMapping
    public String addBooking(@RequestParam String departureAirport,
                             @RequestParam String destinationAirport,
                             @RequestParam String departureDate,
                             @RequestParam String returnDate,
                             @RequestParam int passengerCount) {
        BookingModel booking = new BookingModel(departureAirport, destinationAirport, LocalDate.parse(departureDate), LocalDate.parse(returnDate), passengerCount);
        bookingService.saveBooking(booking);
        return "redirect:/bookings/listBookings";
    }
}
