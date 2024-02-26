package ladder.exception.participant;

public class NoSuchParticipantException extends IllegalArgumentException {
    private static final String MESSAGE = "입력되지 않은 참가자 이름입니다.";

    public NoSuchParticipantException() {
        super(MESSAGE);
    }
}
