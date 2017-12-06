package pl.s2devs.shared.response.person;


/**
 * Created by rafal on 14.11.17.
 */
public class RegistrationResponse<T> {

    public enum Code {
        EMAIL_TAKEN, REGISTERED
    }

    private T person;
    private Code code;

    public RegistrationResponse(T person, Code code) {
        this.person = person;
        this.code = code;
    }

    public T getPerson() {
        return person;
    }

    public Code getCode() {
        return code;
    }
}
