package exception;

import view.input.ErrorMessage;

public class InvalidLineWeightException extends IllegalArgumentException {

    public InvalidLineWeightException() {
        super(ErrorMessage.INVALID_LINE_WEIGHT.getMessage());
    }
}
