package exception;

import view.input.ErrorMessage;

public class InvalidResultNameException extends IllegalArgumentException {

    public InvalidResultNameException() {
        super(ErrorMessage.INVALID_RESULT_NAME.getMessage());
    }
}
