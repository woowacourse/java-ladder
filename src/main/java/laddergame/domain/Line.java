package laddergame.domain;

import laddergame.domain.strategy.LineBuildStrategy;

import java.util.List;

public class Line {
    private List<Zone> zones;

    public Line(final List<Zone> zones) {
        this.zones = zones;
    }

    public static Line buildOf(final LineBuildStrategy lineBuildStrategy,
                               final int width)
    {
        return new Line(lineBuildStrategy.apply(width));
    }

    public List<Zone> getZones() {
        return zones;
    }
}
