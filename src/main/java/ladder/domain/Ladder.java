package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private List<Line> ladder = new ArrayList<>();

    public List<Line> createLadder(final int ladderHeight, final int numberOfPlayers) {
        for (int i = 0; i < ladderHeight; i++) {
            Line line = new Line(new RandomValue(), numberOfPlayers);

            ladder.add(line);
        }

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
}
