package domain;

public class WinningResult {

    private static final String INVALID_RESULT_LENGTH_MESSAGE = "실행결과는 1~5자리까지 입력 가능합니다.";
    private static final String INVALID_RESULT_BLANK_MESSAGE = "실행결과는 공백으로만 이루어지면 안됩니다.";
    private final String winningResult;

    public WinningResult(final String winningResult) {
        validate(winningResult);
        validateIsBlank(winningResult);
        this.winningResult = winningResult;
    }

    private void validate(final String winningResult) {
        if (winningResult.length() < 1 || winningResult.length() > 5) {
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
