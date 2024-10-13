package it.unicam.ids.Vseet.Controller;

import it.unicam.ids.Vseet.Model.Entities.Content;
import it.unicam.ids.Vseet.Model.Entities.User;
import it.unicam.ids.Vseet.Model.Exceptions.ContentNotFoundException;
import it.unicam.ids.Vseet.Model.Exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<String> handleContentNotFound(ContentNotFoundException exception) {
        return new ResponseEntity<>("Content not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<String> handleUserNotFound(UserNotFoundException exception) {
        return new ResponseEntity<>("User not found.", HttpStatus.NOT_FOUND);
    }
}
