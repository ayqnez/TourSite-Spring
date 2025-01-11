package kz.kassen.Tour_App.repo;

import kz.kassen.Tour_App.models.BookingModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<BookingModel, Long> {
}
