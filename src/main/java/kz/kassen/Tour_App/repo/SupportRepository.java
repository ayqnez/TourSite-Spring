package kz.kassen.Tour_App.repo;

import kz.kassen.Tour_App.models.SupportModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportRepository extends JpaRepository<SupportModel, Long> { }
