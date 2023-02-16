package exception;

public class WrongParticipantSizeException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "최소 2명의 이름을 입력해주세요.";

    public WrongParticipantSizeException() {
        super(DEFAULT_MESSAGE);
    }
}
