package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Exception> badRequestHandler() {
        Exception ex = new Exception();
        ex.setError("Bad Request");
        ex.setMessage("Bad Request");
        ex.setStatus(400);
        return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<Exception> notFoundHandler() {
        Exception ex = new Exception();
        ex.setError("Not Found");
        ex.setMessage("This id does not exist");
        ex.setStatus(404);
        return new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RoomUnavailableException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<Exception> roomUnavailableHandler() {
        Exception ex = new Exception();
        ex.setError("Conflict");
        ex.setMessage("This room is being booked");
        ex.setStatus(409);
        return new ResponseEntity<>(ex, HttpStatus.CONFLICT);
    }
}
