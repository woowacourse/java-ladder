package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private List<Line> lines;

    public Ladder(int countOfPerson, int ladderHeight ,LineGenerator lineGenerator){
        lines = new ArrayList<>();
        for (int i = 1; i <= ladderHeight; i++) {
            lines.add(lineGenerator.drawLine(countOfPerson - 1));
        }
    }

    public Direction CurrentDirection(int height, int playerPosition) {
        if (playerPosition == 0) {
            return new Direction(false, lines.get(height).getLinePosition(playerPosition));
        }
        if (playerPosition == lines.get(height).getRowLines().size()) {
            return new Direction(lines.get(height).getLinePosition(playerPosition - 1), false);
        }
        return new Direction(lines.get(height).getLinePosition(playerPosition - 1), lines.get(height).getLinePosition(playerPosition));
    }

    public List<Line> getLadder() {
        return lines;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(lines, ladder.lines);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lines);
    }
}