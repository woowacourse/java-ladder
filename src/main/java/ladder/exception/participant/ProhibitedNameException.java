package ladder.exception.participant;

public class ProhibitedNameException extends IllegalArgumentException {
    private static final String MESSAGE = "all은 사용자 이름이 될 수 없습니다.";

    public ProhibitedNameException() {
        super(MESSAGE);
    }
}
