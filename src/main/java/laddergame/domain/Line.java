package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Boolean> points;

    public Line(final int playerCount) {
        this.points = new ArrayList<>(Collections.nCopies(playerCount, Boolean.FALSE));
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
