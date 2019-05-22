package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private static final int MINIMUM_HEIGHT = 1;

    private List<Crosspoints> ladderRows = new ArrayList<>();

    public Ladder(int height, CrossbarGenerator crossbarGenerator) {
        validateHeight(height);
        for (int i = 0; i < height; i++) {
            ladderRows.add(crossbarGenerator.generateCrossbars());
        }
    }

    public List<Crosspoints> getLadderRows() {
        return ladderRows;
    }

    private void validateHeight(int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 1이상이어야 합니다.");
        }
    }

    public int answerResultPositionOf(int playerPosition) {
        int currentPosition = playerPosition;

        for (Crosspoints crosspoints : ladderRows) {
            currentPosition = crosspoints.answerResultIndexOf(currentPosition);
        }
        return currentPosition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder1 = (Ladder) o;
        return Objects.equals(ladderRows, ladder1.ladderRows);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderRows);
    }
}
