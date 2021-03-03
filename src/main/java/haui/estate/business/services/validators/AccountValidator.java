package haui.estate.business.services.validators;

import haui.estate.business.models.bos.Response;
import haui.estate.business.models.bos.SystemResponse;
import haui.estate.business.models.requests.SignupRq;
import haui.estate.business.utils.StringRp;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class AccountValidator {

    private static final String PHONE_REGEX = "^(03[^01]|04[8]|05[2689]|07[06789]|08[^0]|09[0-9])[0-9]{7}$";
    private static final String USERNAME_REGEX = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*]).{8,}$";
    private static final String EMAIL_REGEX = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
    public ResponseEntity<SystemResponse<Object>> validate(SignupRq signupRq){

        if(!Pattern.compile(PHONE_REGEX).matcher(signupRq.getPhone()).matches()){
            return Response.badRequest(StringRp.PHONE_NOT_VALID);
        }
        if(!Pattern.compile(USERNAME_REGEX).matcher(signupRq.getUserName()).matches()){
            return Response.badRequest(StringRp.USERNAME_NOT_VALID);
        }
        if(!Pattern.compile(PASSWORD_REGEX).matcher(signupRq.getPassword()).matches()){
            return Response.badRequest(StringRp.PASSWORD_NOT_VALID);
        }
        if(!Pattern.compile(EMAIL_REGEX).matcher(signupRq.getEmail()).matches()){
            return Response.badRequest(StringRp.EMAIL_NOT_VALID);
        }
            return Response.ok();
    }
}
