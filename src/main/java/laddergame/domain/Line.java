package laddergame.domain;

import laddergame.domain.strategy.LineBuildStrategy;

import java.util.Collections;
import java.util.List;

public class Line {
    private List<Zone> zones;

    public Line(final LineBuildStrategy lineBuildStrategy,
                final int width) {
        this.zones = lineBuildStrategy.apply(width);
    }

    public List<Zone> getZones() {
        return Collections.unmodifiableList(zones);
    }
}
