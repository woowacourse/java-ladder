package exception;

public class InvalidLadderHeightException extends IllegalArgumentException {

    public InvalidLadderHeightException() {
        super("사다리의 높이는 1이상 10이하의 숫자입니다. 다시 입력해주세요.");
    }
}
