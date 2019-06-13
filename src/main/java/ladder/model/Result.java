package ladder.model;

import java.util.Objects;

public class Result {
    private final String result;
    private final String winner;

    public Result(String result, String winner) {
        this.result = result;
        this.winner = winner;
    }

    public boolean isEqualsWinnerName(String member) {
        return winner.equals(member);
    }

    @Override
    public boolean equals(Object another) {
        if (this == another) return true;
        if (another == null || getClass() != another.getClass()) return false;
        Result result1 = (Result) another;
        return Objects.equals(result, result1.result) &&
                Objects.equals(winner, result1.winner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, winner);
    }

    @Override
    public String toString() {
        return winner + " : " + result;
    }
}
