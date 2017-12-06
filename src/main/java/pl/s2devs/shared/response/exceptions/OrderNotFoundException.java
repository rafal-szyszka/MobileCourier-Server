package pl.s2devs.shared.response.exceptions;

/**
 * Created by rafal on 01.12.17.
 */
public class OrderNotFoundException extends Exception {

    public OrderNotFoundException(String message) {
        super(message);
    }
}
