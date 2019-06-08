package ladder.model;

import java.util.Objects;

public class Result {
    private final String result;
    private final String winner;

    public Result(String result, String winner) {
        this.result = result;
        this.winner = winner;
    }

    public boolean isWinner(String member) {
        return winner.equals(member);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result result1 = (Result) o;
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
