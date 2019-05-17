package ladder.domain;

import ladder.domain.generator.SubLineGenerator;
import ladder.domain.generator.SubLineRandomGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Line {
    private static final int MIN_PLAYER = 2;

    private final List<Boolean> subLines;

    public Line(final int countOfPerson) {
        this(countOfPerson, new SubLineRandomGenerator(countOfPerson));
    }

    public Line(final int countOfPerson, SubLineGenerator subLineGenerator) {
        validateSize(countOfPerson);
        this.subLines = new ArrayList<>(subLineGenerator.generate());
        validateDuplication(subLines);
    }

    private void validateSize(int countOfPerson) {
        if (countOfPerson < MIN_PLAYER) {
            throw new IllegalArgumentException("사람수는 2명 이상 이어야 합니다.");
        }
    }

    private void validateDuplication(List<Boolean> subLines) {
        for (int i = 1; i < subLines.size(); i++) {
            validateDuplication(subLines.get(i), subLines.get(i - 1));
        }
    }

    private void validateDuplication(boolean first, boolean second) {
        if (first && second) {
            throw new IllegalArgumentException("Line.class validate Duplication Error");
        }
    }

    public List<Boolean> getSubLines() {
        return subLines;
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