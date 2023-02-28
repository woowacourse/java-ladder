package domain;

public class WinningResult {

    private static final int WINNING_RESULT_MIN_LENGTH = 1;
    private static final int WINNING_RESULT_MAX_LENGTH = 5;
    private static final String INVALID_RESULT_LENGTH_MESSAGE = "실행결과는 1~5자리까지 입력 가능합니다.";
    private static final String INVALID_RESULT_BLANK_MESSAGE = "실행결과는 공백으로만 이루어지면 안됩니다.";
    private final String winningResult;

    public WinningResult(final String winningResult) {
        validate(winningResult);
        this.winningResult = winningResult;
    }

    private void validate(final String winningResult) {
        validateWinningResultLength(winningResult);
        validateIsBlank(winningResult);
    }

    private void validateWinningResultLength(final String winningResult) {
        if (winningResult.length() < WINNING_RESULT_MIN_LENGTH || winningResult.length() > WINNING_RESULT_MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_RESULT_LENGTH_MESSAGE);
        }
    }

    private void validateIsBlank(final String winningResult) {
        if (winningResult.isBlank()) {
            throw new IllegalArgumentException(INVALID_RESULT_BLANK_MESSAGE);
        }
    }

    public String getWinningResult() {
        return winningResult;
    }
}
