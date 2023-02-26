package domain;

public class WinningResult {
    private final String winningResult;

    public WinningResult(final String winningResult) {
        validate(winningResult);
        this.winningResult = winningResult;
    }

    private void validate(final String winningResult) {
        System.out.println(winningResult.length());
        if (winningResult.length() < 1 || winningResult.length() > 5) {
            throw new IllegalArgumentException("실행결과는 1~5자리까지 입력 가능합니다.");
        }
    }
}
