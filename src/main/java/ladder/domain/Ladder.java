package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private List<Line> ladder = new ArrayList<>();

    public void createLadder(final int ladderHeight, final int numberOfPlayers) {
        for (int i = 0; i < ladderHeight; i++) {
            Line line = new Line(numberOfPlayers);
            line.createLine(new RandomValue());

            ladder.add(line);
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

    public List<Line> getLadder() {
        return ladder;
    }
}
