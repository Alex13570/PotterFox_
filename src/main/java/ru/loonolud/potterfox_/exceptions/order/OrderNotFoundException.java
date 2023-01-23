package ru.loonolud.potterfox_.exceptions.order;

import org.springframework.http.HttpStatus;
import ru.loonolud.potterfox_.exceptions.PotterFoxException;

public class OrderNotFoundException extends PotterFoxException {

    public OrderNotFoundException() {
        super("Order not found", HttpStatus.NOT_FOUND);
    }
}
