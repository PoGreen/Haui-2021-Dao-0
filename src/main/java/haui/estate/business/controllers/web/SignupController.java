package haui.estate.business.controllers.web;

import haui.estate.business.models.bos.SystemResponse;
import haui.estate.business.models.requests.SignupRq;
import haui.estate.business.services.ISignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Controller(value = "signup")
public class SignupController {

    @Autowired
    private ISignupService iSignupService;

    @GetMapping(value = "/signup")
    public String getSignupPage(){
        return "signup";
    }

    @PostMapping(value = "/signup")
    public ResponseEntity<SystemResponse<Object>> signup(@Valid @RequestBody SignupRq signupRq){
        return iSignupService.signup(signupRq);
    }
}
