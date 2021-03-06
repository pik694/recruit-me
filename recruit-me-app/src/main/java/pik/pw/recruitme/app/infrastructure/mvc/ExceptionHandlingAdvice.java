package pik.pw.recruitme.app.infrastructure.mvc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class ExceptionHandlingAdvice {
    @ExceptionHandler(ObjectNotFoundException.class)
    ResponseEntity<ErrorMessage> handleNotFoundRecruiter(ObjectNotFoundException e) {
        ErrorMessage errorMessage = new ErrorMessage(e.getMessage());
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }

    @Getter
    @AllArgsConstructor
    class ErrorMessage {
        private String message;
        private String details;

        public ErrorMessage(String message) {
            this.message = message;
        }
    }
}
