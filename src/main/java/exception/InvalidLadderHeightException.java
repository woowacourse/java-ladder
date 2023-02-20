package exception;

import view.input.ErrorMessage;

public class InvalidLadderHeightException extends IllegalArgumentException {

    public InvalidLadderHeightException() {
        super(ErrorMessage.INVALID_LADDER_HEIGHT.getMessage());
    }
}
