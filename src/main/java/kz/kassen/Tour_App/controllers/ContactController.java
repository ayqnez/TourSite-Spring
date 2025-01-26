package kz.kassen.Tour_App.controllers;

import kz.kassen.Tour_App.models.ContactModel;
import kz.kassen.Tour_App.services.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/contacts")
public class ContactController {
    private final ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping()
    public String contactPate() {
        return "contacts";
    }

    @PostMapping()
    public String addContact(@RequestParam String name,
                             @RequestParam String email,
                             @RequestParam String message) {
        ContactModel model = new ContactModel(name, email, message);
        contactService.saveContact(model);
        return "redirect:/contacts";
    }
}
