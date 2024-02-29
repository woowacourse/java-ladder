package ladderGame.model;

import java.util.Objects;

public class LadderResult {
    private final String LadderResult;

    public LadderResult(String ladderResult) {
        LadderResult = ladderResult;
    }

    public String getLadderResult() {
        return LadderResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderResult that = (LadderResult) o;
        return Objects.equals(LadderResult, that.LadderResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LadderResult);
    }
}
