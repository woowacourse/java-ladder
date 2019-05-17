package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private static final int MINIMUM_HEIGHT = 1;
    private List<Crosspoints> ladderRows = new ArrayList<>();
    private List<ResultItem> resultItems;

    public Ladder(int height, List<ResultItem> resultItems, CrossbarGenerator crossbarGenerator) {
        validateHeight(height);
        for (int i = 0; i < height; i++) {
            ladderRows.add(crossbarGenerator.generateCrossbars());
        }

        validateNumberOfResultItems(resultItems.size());
        this.resultItems = resultItems;
    }

    public List<Crosspoints> getLadderRows() {
        return ladderRows;
    }

    public List<ResultItem> getResultItems() {
        return resultItems;
    }

    private void validateNumberOfResultItems(int numberOfResultItems) {
        int numberOfPlayer = ladderRows.get(0).width();

        if (numberOfResultItems != numberOfPlayer) {
            throw new IllegalArgumentException("당첨 상품의 수는 플레이어의 수와 같아야 합니다.");
        }
    }

    private void validateHeight(int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException("사다리의 높이는 1이상이어야 합니다.");
        }
    }

    public ResultItem answerResult(int playerPosition) {
        int currentPosition = playerPosition;

        for (Crosspoints crosspoints : ladderRows) {
            currentPosition = crosspoints.answerResultIndexOf(currentPosition);
        }
        return resultItems.get(currentPosition);
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
