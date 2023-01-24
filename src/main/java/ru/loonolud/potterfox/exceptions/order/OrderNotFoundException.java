package ru.loonolud.potterfox.exceptions.order;

import org.springframework.http.HttpStatus;
import ru.loonolud.potterfox.exceptions.PotterFoxException;

public class OrderNotFoundException extends PotterFoxException {

    public OrderNotFoundException() {
        super("Order not found", HttpStatus.NOT_FOUND);
    }
}
