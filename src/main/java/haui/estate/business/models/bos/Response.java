package haui.estate.business.models.bos;


import haui.estate.business.utils.StatusRp;
import haui.estate.business.utils.StringRp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response {
    /*
    response success process
     */
    private Response() {
    }

    public static <T> ResponseEntity<SystemResponse<T>> ok(int code, String msg, T body) {
        return ResponseEntity.ok(new SystemResponse<>(code, msg, body));
    }

    public static <T> ResponseEntity<SystemResponse<T>> ok(int code, String msg) {
        return ResponseEntity.ok(new SystemResponse<>(code, msg, null));
    }

    public static <T> ResponseEntity<SystemResponse<T>> ok(String msg) {
        return ResponseEntity.ok(new SystemResponse<>(StatusRp.OK, msg, null));
    }

    public static <T> ResponseEntity<SystemResponse<T>> ok() {
        return ResponseEntity.ok(new SystemResponse<>(StatusRp.OK, null));
    }

    public static <T> ResponseEntity<SystemResponse<T>> ok(String msg, T data) {
        return ResponseEntity.ok(new SystemResponse<>(StatusRp.OK, msg, data));
    }

    public static <T> ResponseEntity<SystemResponse<T>> ok(T data) {
        return ResponseEntity.ok(new SystemResponse<>(StatusRp.OK, StringRp.SUCCESS, data));
    }

    public static <T> ResponseEntity<SystemResponse<T>> ok(SystemResponse<T> body) {
        return ResponseEntity.ok(body);
    }

    /*
    response unauthorized process
     */

    public static <T> ResponseEntity<SystemResponse<T>> unauthorized(String msg) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .body(new SystemResponse<>(401, msg));
    }

    public static <T> ResponseEntity<SystemResponse<T>> unauthorized() {
        return ResponseEntity.status(StatusRp.UNAUTHORIZED).body(new SystemResponse<>(StatusRp.UNAUTHORIZED));
    }

    public static <T> ResponseEntity<SystemResponse<T>> unauthorized(SystemResponse<T> body) {
        return ResponseEntity.status(StatusRp.UNAUTHORIZED).body(body);
    }

    /*
    response bad request
     */

    public static <T> ResponseEntity<SystemResponse<T>> badRequest() {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new SystemResponse<>(StatusRp.BAD_REQUEST, StringRp.NOT_FOUND));
    }

    public static <T> ResponseEntity<SystemResponse<T>> badRequest(T data) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new SystemResponse<>(StatusRp.BAD_REQUEST, StringRp.BAD_REQUEST, data));
    }


    public static <T> ResponseEntity<SystemResponse<T>> badRequest(String msg) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new SystemResponse<>(400, msg));
    }

    public static <T> ResponseEntity<SystemResponse<T>> badRequest(int code, String msg) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new SystemResponse<>(code, msg));
    }

    public static <T> ResponseEntity<SystemResponse<T>> badRequest(int code, String msg, T data) {
        return ResponseEntity.badRequest().body(new SystemResponse<>(code, msg, data));
    }

    public static <T> ResponseEntity<SystemResponse<T>> unauthorized(int code, String msg, T data) {
        return ResponseEntity.badRequest().body(new SystemResponse<>(code, msg, data));
    }

    public static <T> ResponseEntity<SystemResponse<T>> unauthorized(String msg, T data) {
        return ResponseEntity.badRequest().body(new SystemResponse<>(401, msg, data));
    }

    public static <T> ResponseEntity<SystemResponse<T>> unauthorized(T data) {
        return ResponseEntity.badRequest().body(new SystemResponse<>(401, StringRp.UNAUTHORIZED, data));
    }

    public static <T> ResponseEntity<SystemResponse<T>> failDependency(int code, String msg) {
        return ResponseEntity.status(424).body(new SystemResponse<>(code, msg));
    }

    /*
    response internal error
     */
    public static <T> ResponseEntity<SystemResponse<T>> internal(String msg) {
        return ResponseEntity
                .status(500)
                .body(new SystemResponse<>(500, msg));
    }


    public static <T> ResponseEntity<SystemResponse<T>> internal(int code, String msg) {
        return ResponseEntity.status(500).body(new SystemResponse<>(code, msg, null));
    }

    public static <T> ResponseEntity<SystemResponse<T>> internal(int code) {
        return ResponseEntity.status(500).body(new SystemResponse<>(code, HttpStatus.INTERNAL_SERVER_ERROR.name(), null));
    }
}
