package ladder.exception;

public class LadderLengthException extends CustomException {

    private static final String MESSAGE = "사다리의 길이는 <플레이어 수 - 1> 이상이어야 합니다.";

    public LadderLengthException() {
        super(MESSAGE);
    }
}
