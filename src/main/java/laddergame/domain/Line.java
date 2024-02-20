package laddergame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import laddergame.util.NumberGenerator;

public class Line {
    private final List<Boolean> points;

    public Line(final int playerCount) {
        this.points = new ArrayList<>(Collections.nCopies(playerCount, Boolean.FALSE));
    }

    public void buildBridge(final int position, final NumberGenerator numberGenerator) {
        if (numberGenerator.generate() == 1) {
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
