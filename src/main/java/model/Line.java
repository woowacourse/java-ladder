package model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Bridge> bridges;

    private Line(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public static Line create(int bridgeCount, BooleanGenerator booleanGenerator) {
        List<Bridge> bridges = new ArrayList<>();
        for (int i = 0; i < bridgeCount; i++) {
            Bridge bridge = new Bridge(booleanGenerator.pick());
            bridges.add(bridge);
        }
        return new Line(bridges);
    }
}
