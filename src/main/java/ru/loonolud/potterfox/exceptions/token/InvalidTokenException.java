package ru.loonolud.potterfox.exceptions.token;

import org.springframework.http.HttpStatus;
import ru.loonolud.potterfox.exceptions.PotterFoxException;

public class InvalidTokenException extends PotterFoxException {
    public InvalidTokenException(String title) {
        super(title, HttpStatus.UNAUTHORIZED);
    }

    public InvalidTokenException() {
        this("Invalid token wtf");
    }
}
