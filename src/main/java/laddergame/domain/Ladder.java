package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private ArrayList<List<Boolean>> ladderMap = new ArrayList<>();
    private final int width;
    private final int height;

    public Ladder(final int width, final int height) {
        LadderValidator.checkConditionsForLadder(height);

        this.width = width;
        this.height = height;

        ladderMap = LadderMapGenerator.fillLadderMap(width, height);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return width == ladder.width &&
                height == ladder.height &&
                Objects.equals(ladderMap, ladder.ladderMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderMap, width, height);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int y = 0; y < height; y++) {
            sb.append("     |");
            toStringLine(sb, y);
        }

        return sb.toString();
    }

    private void toStringLine(StringBuilder sb, int y) {
        for (int x = 0; x < width - 1; x++) {
            sb.append(ladderMap.get(y).get(x) ? "-----|" : "     |");
        }
        sb.append("\n");
    }
}
