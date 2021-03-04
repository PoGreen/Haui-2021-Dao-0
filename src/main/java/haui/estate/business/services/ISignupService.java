package haui.estate.business.services;

import haui.estate.business.models.bos.SystemResponse;
import haui.estate.business.models.requests.SignupRq;
import org.springframework.http.ResponseEntity;

public interface ISignupService {
    ResponseEntity<SystemResponse<Object>> signup(SignupRq signupRq);
}
