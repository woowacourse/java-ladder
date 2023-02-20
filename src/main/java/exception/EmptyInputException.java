package exception;

import view.input.ErrorMessage;

public class EmptyInputException extends IllegalArgumentException {

    public EmptyInputException() {
        super(ErrorMessage.EMPTY_INPUT.getMessage());
    }
}
