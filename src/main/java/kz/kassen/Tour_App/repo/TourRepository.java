package kz.kassen.Tour_App.repo;

import kz.kassen.Tour_App.models.TourModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TourRepository extends JpaRepository<TourModel, Long> {
    List<TourModel> findByPriceBetween(double min, double max);
}
