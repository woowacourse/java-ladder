package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private final List<Line> ladder = new ArrayList<>();

    public Ladder(final int width, final int height) {
        LadderValidator.checkConditionsForLadder(height);

        makeLadder(width, height);
    }

    private void makeLadder(int width, int height) {
        for (int i = 0; i < height; i++) {
            ladder.add(LineGenerator.makeLine(width));
        }
    }

    public List<Line> getLadder() {
        return this.ladder;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < ladder.size(); i++) {
            sb.append(ladder.get(i));
        }

        return sb.toString();
    }
}
