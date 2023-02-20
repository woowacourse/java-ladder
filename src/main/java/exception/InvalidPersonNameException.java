package exception;

import view.input.ErrorMessage;

public class InvalidPersonNameException extends IllegalArgumentException {

    public InvalidPersonNameException() {
        super(ErrorMessage.INVALID_PERSON_NAME.getMessage());
    }
}
