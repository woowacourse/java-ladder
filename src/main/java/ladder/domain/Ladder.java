package ladder.domain;

import java.util.List;
import java.util.Objects;

public class Ladder {
    private List<Crossbars> ladder;

    public Ladder(int height, CrossbarGenerator crossbarGenerator) {
        validateHeight(height);
    }

    private void validateHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("사다리의 높이는 1이상이어야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder1 = (Ladder) o;
        return Objects.equals(ladder, ladder1.ladder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladder);
    }
}
