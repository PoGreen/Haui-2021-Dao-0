package haui.estate.business.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller(value = "home")
public class HomeController {

    @GetMapping(value = "/contact")
    public String getHomePage(){
        return "contact";
    }
}
