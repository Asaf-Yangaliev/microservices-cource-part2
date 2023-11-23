package uz.yangaliev.userservice.configuration;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uz.yangaliev.userservice.exception.UserUnauthorizedException;

@ControllerAdvice
public class MathServiceExceptionHandler {

    @ExceptionHandler(UserUnauthorizedException.class)
    public ResponseEntity<ErrorResponseBody> handleUnauthorizedException(UserUnauthorizedException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorResponseBody(e.getMessage()));
    }
}
