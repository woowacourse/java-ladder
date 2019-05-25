package ladder.domain;

import java.util.Objects;

public class LadderMatchingPair {
    private final Name from, to;

    LadderMatchingPair(Name from, Name to) {
        this.from = from;
        this.to = to;
    }

    public static LadderMatchingPair of(Name from, Name to) {
        return new LadderMatchingPair(from, to);
    }

    @Override
    public String toString() {
        return String.format("%s : %s", from.getName(), to.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LadderMatchingPair that = (LadderMatchingPair) o;
        return Objects.equals(from.getName(), that.from.getName()) &&
                Objects.equals(to.getName(), that.to.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
