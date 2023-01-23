package ru.loonolud.potterfox_.exceptions.product;

import org.springframework.http.HttpStatus;
import ru.loonolud.potterfox_.exceptions.PotterFoxException;

public class ProductNotFoundException extends PotterFoxException {

    public ProductNotFoundException() {
        super("Product with this id does not exist!", HttpStatus.NOT_FOUND);
    }
}
