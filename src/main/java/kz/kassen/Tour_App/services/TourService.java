package kz.kassen.Tour_App.services;

import kz.kassen.Tour_App.models.TourModel;
import kz.kassen.Tour_App.repo.TourRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TourService {
    private final TourRepository tourRepository;

    public TourService(TourRepository tourRepository) {
        this.tourRepository = tourRepository;
    }

    public List<TourModel> getAllTours() {
        return tourRepository.findAll();
    }

    public Optional<TourModel> getTourById(Long id) {
        return tourRepository.findById(id);
    }

    public void saveTour(TourModel tour) {
        tourRepository.save(tour);
    }

    public List<TourModel> getToursByPriceBetween(Double minPrice, Double maxPrice) {
        return tourRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<TourModel> getToursByCategory(String category) {
        return tourRepository.findByCategory(category);
    }
}
