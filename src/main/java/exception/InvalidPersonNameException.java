package exception;

public class InvalidPersonNameException extends IllegalArgumentException {

    public InvalidPersonNameException() {
        super(ErrorMessage.INVALID_PERSON_NAME.getMessage());
    }
}
