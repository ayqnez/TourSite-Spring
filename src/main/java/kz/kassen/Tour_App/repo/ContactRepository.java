package kz.kassen.Tour_App.repo;

import kz.kassen.Tour_App.models.ContactModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactModel, Long> {
}
