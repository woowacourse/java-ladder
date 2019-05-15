package laddergame.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Ladder {
    private final int width;
    private final int height;
    private final ArrayList<ArrayList<Boolean>> ladderMap = new ArrayList<ArrayList<Boolean>>();

    public Ladder(final int width, final int height) {
        LadderValidator.checkConditionsForLadder(height);

        this.width = width - 1;
        this.height= height;
    }

    //private void

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ladder ladder = (Ladder) o;
        return Objects.equals(ladderMap, ladder.ladderMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ladderMap);
    }
}
