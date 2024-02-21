package ladder.exception;

public class DuplicatedNamesException extends IllegalArgumentException {
    private static final String MESSAGE = "중복된 이름이 입력되었습니다.";

    public DuplicatedNamesException() {
        super(MESSAGE);
    }
}
