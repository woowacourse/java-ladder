package laddergame.domain;

import java.util.Objects;

public class WinningPrize {

    private final String winningPrize;

    public WinningPrize(final String winningPrize) {
        validateBlank(winningPrize);
        this.winningPrize = winningPrize;
    }

    private void validateBlank(final String winningPrize) {
        if (winningPrize.isBlank()) {
            throw new IllegalArgumentException("실행 결과는 빈칸이 될 수 없습니다.");
        }
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final WinningPrize that = (WinningPrize) o;
        return Objects.equals(winningPrize, that.winningPrize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningPrize);
    }

    public String getWinningPrize() {
        return winningPrize;
    }

    public int getWinningPrizeLength() {
        return winningPrize.length();
    }
}
