package ladder.domain;

import java.util.*;

public class Ladder {
    private List<Crosspoints> ladder = new ArrayList<>();

    public Ladder(int height, CrossbarGenerator crossbarGenerator) {
        validateHeight(height);
        for (int i = 0; i < height; i++) {
            ladder.add(crossbarGenerator.generateCrossbars());
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

    public HashMap<Player, ResultItem> startLadderGame(PlayerGroup players, ResultItems resultItems) {
        for (Crosspoints crosspoints : ladder) {
            players.changePositionBy(crosspoints);
        }

        return resultItems.makeLaddringResult(players);
    }
}
