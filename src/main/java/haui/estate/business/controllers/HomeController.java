package haui.estate.business.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {

    @GetMapping(value = "/contact")
    public String getHomePage(){
        return "contact";
    }
}
