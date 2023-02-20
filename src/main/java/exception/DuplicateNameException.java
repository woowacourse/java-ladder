package exception;

import view.input.ErrorMessage;

public class DuplicateNameException extends IllegalArgumentException {

    public DuplicateNameException() {
        super(ErrorMessage.DUPLICATE_NAME.getMessage());
    }
}
