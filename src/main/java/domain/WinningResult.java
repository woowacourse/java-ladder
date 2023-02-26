package domain;

public class WinningResult {
    private final String winningResult;

    public WinningResult(final String winningResult) {
        validate(winningResult);
        validateIsBlank(winningResult);
        this.winningResult = winningResult;
    }

    private void validate(final String winningResult) {
        if (winningResult.length() < 1 || winningResult.length() > 5) {
            throw new IllegalArgumentException("실행결과는 1~5자리까지 입력 가능합니다.");
        }
    }

    private void validateIsBlank(final String winningResult) {
        if (winningResult.isBlank()) {
            throw new IllegalArgumentException("실행결과는 공백으로만 이루어지면 안됩니다.");
        }
    }

    public String getWinningResult() {
        return winningResult;
    }
}
