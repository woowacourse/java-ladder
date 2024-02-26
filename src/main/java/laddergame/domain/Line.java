package laddergame.domain;

import laddergame.domain.strategy.ZonesBuilder;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Zone> zones;

    public Line(final ZonesBuilder zonesBuilder,
                final int width) {
        this.zones = zonesBuilder.build(width);
    }

    public List<Zone> getZones() {
        return Collections.unmodifiableList(zones);
    }
}
