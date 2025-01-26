package kz.kassen.Tour_App.services;

import kz.kassen.Tour_App.models.ContactModel;
import kz.kassen.Tour_App.models.SupportModel;
import kz.kassen.Tour_App.repo.ContactRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public void saveContact(ContactModel contactModel) {
        contactRepository.save(contactModel);
    }
}
