package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<Bridge> bridges;

    private Line(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public static Line fromBridgeCount(int bridgeCount) {
        List<Bridge> bridges = new ArrayList<>();
        for (int i = 0; i < bridgeCount; i++) {
            Bridge bridge = new Bridge(new Random().nextBoolean());
            bridges.add(bridge);
        }
        return new Line(bridges);
    }
}
