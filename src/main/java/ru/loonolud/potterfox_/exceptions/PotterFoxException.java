package ru.loonolud.potterfox_.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class PotterFoxException extends RuntimeException {

    private final HttpStatus httpStatus;

    public PotterFoxException(String title, HttpStatus status) {
        super(title);
        httpStatus = status;
    }
}
