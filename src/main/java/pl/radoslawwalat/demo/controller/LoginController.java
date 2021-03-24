package pl.radoslawwalat.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    private Validator validator;

    public LoginController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }
}
