package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private List<Crosspoints> ladder = new ArrayList<>();
    private List<ResultItem> resultItems;

    public Ladder(int height, CrossbarGenerator crossbarGenerator) {
        validateHeight(height);
        for (int i = 0; i < height; i++) {
            ladder.add(crossbarGenerator.generateCrossbars());
        }
    }

    public Ladder(int height, List<ResultItem> resultItems, CrossbarGenerator crossbarGenerator) {
        validateHeight(height);
        for (int i = 0; i < height; i++) {
            ladder.add(crossbarGenerator.generateCrossbars());
        }
        validateNumberOfResultItems(resultItems.size());
        this.resultItems = resultItems;
    }

    private void validateNumberOfResultItems(int numberOfResultItems) {
        if(numberOfResultItems != ladder.get(0).width()){
            throw new IllegalArgumentException("당첨 상품의 수는 플레이어의 수와 같아야 합니다.");
        }
    }

    private void validateHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("사다리의 높이는 1이상이어야 합니다.");
        }
    }

    public List<Crosspoints> getLadder() {
        return ladder;
    }

    public ResultItem answerResult(int playerPosition) {
        int currentPosition = playerPosition;

        for (Crosspoints crosspoints : ladder) {
            currentPosition = crosspoints.answerResultIndexOf(currentPosition);
        }

        return resultItems.get(currentPosition);
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

    public List<ResultItem> getResultItems() {
        return resultItems;
    }
}
