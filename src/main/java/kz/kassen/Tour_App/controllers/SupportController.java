package kz.kassen.Tour_App.controllers;

import kz.kassen.Tour_App.models.SupportModel;
import kz.kassen.Tour_App.services.SupportService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/addSupport")
public class SupportController {

    private final SupportService supportService;

    public SupportController(SupportService supportService) {
        this.supportService = supportService;
    }

    @GetMapping()
    public String contactForm(Model model) {
        model.addAttribute("reviews", supportService.getAllSupports());
        return "support";
    }

    @PostMapping()
    public String addSupport(@RequestParam String name,
                             @RequestParam String email,
                             @RequestParam String message,
                             Model model) {
        SupportModel supportModel = new SupportModel(name, email, message);
        supportService.saveSupport(supportModel);

        return "redirect:/support";
    }
}
