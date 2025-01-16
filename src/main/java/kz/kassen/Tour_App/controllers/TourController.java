package kz.kassen.Tour_App.controllers;

import kz.kassen.Tour_App.models.TourModel;
import kz.kassen.Tour_App.services.TourService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tours")
public class TourController {
    private final TourService tourService;

    public TourController(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping("/list")
    public String listTours(Model model) {
        model.addAttribute("tours", tourService.getAllTours());
        return "list";
    }

    @GetMapping("/{id}")
    public String tourDetails(@PathVariable Long id, Model model) {
       TourModel tour = tourService.getTourById(id).orElse(null);
       model.addAttribute("tour", tour);
       return "details";
    }

    @PostMapping
    public String addTour(@RequestParam String title,
                          @RequestParam String description,
                          @RequestParam double price,
                          @RequestParam String category) {
        TourModel newTour = new TourModel(title, description, price, category);
        tourService.saveTour(newTour);
        return "redirect:/tours/list";
    }

    @GetMapping("/add")
    public String addTourForm() {
        return "addTour";
    }

    @GetMapping("/filterByPrice")
    public String filterByPrice(@RequestParam(required = false) Double minPrice,
                              @RequestParam(required = false) Double maxPrice,
                              Model model) {
        if (minPrice == null) minPrice = 0.0;
        if (maxPrice == null) maxPrice = 0.0;

        List<TourModel> filteredTours = tourService.getToursByPriceBetween(minPrice, maxPrice);
        model.addAttribute("tours", filteredTours);
        model.addAttribute("minPrice", minPrice);
        model.addAttribute("maxPrice", maxPrice);

        return "filterByPrice";
    }

    @GetMapping("/filterByCategory")
    public String filterByCategory(@RequestParam(required = false) String category, Model model) {
        List<TourModel> filteredTours = tourService.getToursByCategory(category);
        model.addAttribute("tours", filteredTours);
        return "filterByCategory";
    }
}
