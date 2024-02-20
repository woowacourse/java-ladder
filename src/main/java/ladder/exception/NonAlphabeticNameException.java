package ladder.exception;

public class NonAlphabeticNameException extends IllegalArgumentException {
    private static final String MESSAGE = "이름은 영어로 입력해 주세요";

    public NonAlphabeticNameException() {
        super(MESSAGE);
    }
}
