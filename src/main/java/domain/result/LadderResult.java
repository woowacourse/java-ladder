package domain.result;

public class LadderResult {
    public static final int MIN_RESULT_LENGTH = 1;
    public static final int MAX_RESULT_LENGTH = 5;
    public static final String LADDER_RESULT_BLANK = "실행 결과에 공백을 사용할 수 없습니다";
    public static final String LADDER_RESULT_LENGTH = String.format("실행 결과는 %d ~ %d글자 사이로 입력해야 합니다",
            MIN_RESULT_LENGTH, MAX_RESULT_LENGTH);

    private final String result;

    public LadderResult(final String result) {
        validate(result);
        this.result = result;
    }

    private void validate(final String result) {
        validateLAdderResultIsBlank(result);
        validateLadderResultLength(result);
    }

    private void validateLAdderResultIsBlank(final String result) {
        if (result.isBlank()) {
            throw new IllegalArgumentException(LADDER_RESULT_BLANK);
        }
    }

    private void validateLadderResultLength(final String result) {
        int resultLength = result.length();
        if (resultLength < MIN_RESULT_LENGTH || resultLength > MAX_RESULT_LENGTH) {
            throw new IllegalArgumentException(LADDER_RESULT_LENGTH);
        }
    }

    public String getValue() {
        return result;
    }
}
