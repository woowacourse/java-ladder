package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Line {
    private final List<Boolean> subLines;

    public Line(final List<Boolean> subLines) {
        validate(subLines);
        this.subLines = new ArrayList<>(subLines);
    }

    private void validate(List<Boolean> subLines) {
        validateSize(subLines);
        validateDuplication(subLines);
    }

    private void validateSize(List<Boolean> subLines) {
        if (subLines.isEmpty()) {
            throw new IllegalArgumentException("사람수는 2명 이상 이어야 합니다.");
        }
    }

    private void validateDuplication(List<Boolean> subLines) {
        for (int i = 1; i < subLines.size(); i++) {
            if (subLines.get(i) && subLines.get(i - 1)) {
                throw new IllegalArgumentException("Line.class validate Duplication Error");
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(subLines, line.subLines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subLines);
    }
}
