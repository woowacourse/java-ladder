package exception;

public class InvalidParticipantsCountException extends IllegalArgumentException {

    public InvalidParticipantsCountException() {
        super(ErrorMessage.INVALID_PARTICIPANT_COUNT.getMessage());
    }
}
