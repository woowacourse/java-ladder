package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private static final int MINIMUM_HEIGHT = 1;

    private List<LadderRow> ladderRows = new ArrayList<>();

    public Ladder(int height, int numberOfPlayer) {
        validateHeight(height);
        for (int i = 0; i < height; i++) {
            ladderRows.add(LadderRow.of(numberOfPlayer));
        }
    }

    Ladder(int height, List<LadderRow> ladderRows) {
        validateHeight(height);
        this.ladderRows = ladderRows;
    }

    private void validateHeight(int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 1이상이어야 합니다.");
        }
    }

    public List<LadderRow> getLadderRows() {
        return ladderRows;
    }

    public int answerResultPositionOf(int playerPosition) {
        int currentPosition = playerPosition;

        for (LadderRow ladderRow : ladderRows) {
            currentPosition = ladderRow.answerResultIndexOf(currentPosition);
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
