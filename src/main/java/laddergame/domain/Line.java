package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import laddergame.util.BooleanGenerator;

public class Line {
    private final List<Boolean> points;

    public Line(final int playerCount) {
        this.points = new ArrayList<>(Collections.nCopies(playerCount - 1, Boolean.FALSE));
    }

    public void buildBridge(final int position, final BooleanGenerator booleanGenerator) {
        if (booleanGenerator.generate()) {
            points.set(position, Boolean.TRUE);
        }
    }

    public boolean isBuilt(final int position) {
        return points.get(position);
    }

    public List<Boolean> getPoints() {
        return points;
    }

}
