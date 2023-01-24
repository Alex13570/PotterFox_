package ru.loonolud.potterfox.exceptions.user;

import org.springframework.http.HttpStatus;
import ru.loonolud.potterfox.exceptions.PotterFoxException;

public class UserNotFoundException extends PotterFoxException {

    public UserNotFoundException() {
        super("User not found", HttpStatus.NOT_FOUND);
    }
}
