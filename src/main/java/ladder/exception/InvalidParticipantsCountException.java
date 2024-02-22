package ladder.exception;

public class InvalidParticipantsCountException extends IllegalArgumentException {
    private static final String MESSAGE = "참가자 수는 2명 이상입니다.";

    public InvalidParticipantsCountException() {
        super(MESSAGE);
    }
}
