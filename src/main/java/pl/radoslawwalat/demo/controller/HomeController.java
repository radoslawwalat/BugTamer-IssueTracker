package pl.radoslawwalat.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "hello";
    }

    @RequestMapping("/dashboard")
    public String dashboard(){ return "dashboard";}


}
