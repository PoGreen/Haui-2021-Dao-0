package haui.estate.business.utils;

public interface StringRp {

    String UNAUTHORIZED = "UNAUTHORIZED!";
    String SUCCESS = "OK!";
    String INVALID_TOKEN = "invalid token!";
    String NOT_FOUND = "not found";
    String BAD_REQUEST = "invalid request";
    String OTP_FALSE = "otp was generated false";
    String OTP_NOT_FOUND = "otp is not found";
    String OTP_REQUEST = "the input was not valid ";
    String INPUT_VALIDATOR = "Input was wrong pattern";

    //category
    String CATEGORY_NOT_FOUND = "category is not exist";
    String OPTION_CONDITION_ERROR = "Option create fields is not null";

    // profile
    String AGE_ENOUGH = "user is not enough age to get account";
    String IMAGES_ENOUGH = "images upload are not enough to update profile";
    String QUESTION_ENOUGH = "questions is not enough to update profile";
    String USER_ID_FAKE = "user id is fake";
    String BANK_ID_FAKE = "bank id is fake";
    String INVALID_MULTIPART_FILES = "invalid multipart file !";

    String USER_IS_EXISTS = "user id exists";
    String WARD_IS_NOT_EXISTS = " ward is not exists";

    // locations
    String PROVINCE_IS_FAKE = "province is fake";
    String DISTRICT_IS_FAKE = "district is fake";
    String WARD_IS_FAKE = "ward is fake";
    // account
    String ACCOUNT_IS_EXIST = "account is exists";
    String PHONE_NOT_VALID = "phone is not valid";
    String USERNAME_NOT_VALID = "username is not valid";
    String EMAIL_NOT_VALID = "email is not valid";
    String PASSWORD_NOT_VALID = "password is not valid";
}
