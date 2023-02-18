package exception;

public class WrongRangeLadderHeightException extends IllegalArgumentException {

    private static final String DEFAULT_MESSAGE = "사다리 높이는 최소 1 이상이어야 합니다.";

    public WrongRangeLadderHeightException() {
        super(DEFAULT_MESSAGE);
    }
}
