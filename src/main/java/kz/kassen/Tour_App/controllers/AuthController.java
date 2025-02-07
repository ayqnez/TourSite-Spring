package kz.kassen.Tour_App.controllers;

import kz.kassen.Tour_App.models.UserModel;
import kz.kassen.Tour_App.repo.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping()
public class AuthController {

    private final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping()
    public String openRegPage() {
        return "register";
    }


    @GetMapping("/main")
    public String openMainPage() {
        return "index";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username,
                               @RequestParam String password,
                               Model model) {

        if (userRepository.findByUsername(username).isPresent()) {
            model.addAttribute("error", "Пользователь с таким именем уже существует");
            return "register";
        }

        UserModel user = new UserModel();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String openLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username,
                            @RequestParam String password,
                            Model model) {
        Optional<UserModel> user = userRepository.findByUsername(username);

        if (user.isPresent() && user.get().getPassword().equals(password)) {
            model.addAttribute("username", user.get().getUsername());
            return "index";
        }

        model.addAttribute("error", "Неверное имя пользователя или пароль");
        return "login";
    }
}
