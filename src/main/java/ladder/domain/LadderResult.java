package ladder.domain;

public class LadderResult {

    private static final String NO_LUCK = "꽝";
    private static final String RESULT_EXCEPT_NO_LUCK_IS_NOT_NUMERIC_ERROR_MESSAGE = "[ERROR] \"꽝\" 이외의 실행 결과는 정수여야합니다.";

    private final String runResult;

    public LadderResult(final String runResult) {
        validate(runResult);
        this.runResult = runResult;
    }

    private void validate(String runResult) {
        if (isNotNoLuck(runResult)) {
            validateNumeric(runResult);
        }
    }

    private boolean isNotNoLuck(String runResult) {
        return !NO_LUCK.equals(runResult);
    }

    private void validateNumeric(String runResult) {
        try {
            Integer.parseInt(runResult);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(RESULT_EXCEPT_NO_LUCK_IS_NOT_NUMERIC_ERROR_MESSAGE);
        }
    }
}
