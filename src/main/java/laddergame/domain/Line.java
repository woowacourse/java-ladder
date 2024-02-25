package laddergame.domain;

import java.util.List;

import laddergame.domain.strategy.LineBuildStrategy;

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
