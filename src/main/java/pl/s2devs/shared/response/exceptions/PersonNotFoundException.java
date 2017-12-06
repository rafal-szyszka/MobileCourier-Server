package pl.s2devs.shared.response.exceptions;

/**
 * Created by rafal on 01.12.17.
 */
public class PersonNotFoundException extends Exception {

    public PersonNotFoundException(String message) {
        super(message);
    }
}
