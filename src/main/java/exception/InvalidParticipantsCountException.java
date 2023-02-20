package exception;

import view.input.ErrorMessage;

public class InvalidParticipantsCountException extends IllegalArgumentException {

    public InvalidParticipantsCountException() {
        super(ErrorMessage.INVALID_PARTICIPANT_COUNT.getMessage());
    }
}
