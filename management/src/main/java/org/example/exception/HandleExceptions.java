package org.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HandleExceptions {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<Exception> handleBadRequest()
    {
        Exception ex = new Exception();
        ex.setError("Bad request parameter");
        ex.setMessage("Bad request");
        ex.setStatus(400);

        return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalServerError.class)
    public ResponseEntity<Exception> handleInternalErrorServer()
    {
        Exception ex = new Exception();
        ex.setError("Internal server error");
        ex.setMessage("Internal server error");
        ex.setStatus(500);

        return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFound.class)
    public ResponseEntity<Exception> handleNotFound()
    {
        Exception ex = new Exception();
        ex.setError("Not found");
        ex.setMessage("Id not found");
        ex.setStatus(404);

        return new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<Exception> handleUsernameNotFound()
    {
        Exception ex = new Exception();
        ex.setError("Not found");
        ex.setMessage("username not found");
        ex.setStatus(404);

        return new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
    }


}
