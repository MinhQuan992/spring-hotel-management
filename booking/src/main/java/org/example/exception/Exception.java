package org.example.exception;

import lombok.Data;

@Data
public class Exception {
    private String message;
    private String error;
    private int status;
}
