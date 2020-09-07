package fatec.projects.app.blog.common.handler;

import fatec.projects.app.blog.common.business.ErrorResponse;
import fatec.projects.app.blog.common.exception.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {
        return new ResponseEntity(
                ErrorResponse.builder()
                        .httpStatus(HttpStatus.NOT_FOUND)
                        .message(ex.getMessage())
                        .timestamp(new Timestamp(System.currentTimeMillis()).getTime())
                        .name(ex.getClass().toString())
                        .build(),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorResponse> handleException(Exception ex) {
        return new ResponseEntity(
                ErrorResponse.builder()
                        .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                        .message(ex.getMessage())
                        .timestamp(new Timestamp(System.currentTimeMillis()).getTime())
                        .name(ex.getClass().toString())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
