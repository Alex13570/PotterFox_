package ru.loonolud.potterfox.exceptions.user;

import org.springframework.http.HttpStatus;
import ru.loonolud.potterfox.exceptions.PotterFoxException;

public class UserUnauthorizedException extends PotterFoxException {
    public UserUnauthorizedException(String title) {
        super(title, HttpStatus.UNAUTHORIZED);
    }
}
