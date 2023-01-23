package ru.loonolud.potterfox_.exceptions.user;

import org.springframework.http.HttpStatus;
import ru.loonolud.potterfox_.exceptions.PotterFoxException;

public class UserEmailAlreadyTakenException extends PotterFoxException {
    public UserEmailAlreadyTakenException() {
        super("Email already taken!", HttpStatus.BAD_REQUEST);
    }
}
