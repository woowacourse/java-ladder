package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineGenerator {
    private final int bridgeCount;

    public LineGenerator(int bridgeCount) {
        this.bridgeCount = bridgeCount;
    }

    public Line generateLine() {
        List<Bridge> bridges = new ArrayList<>();
        for (int i = 0; i < bridgeCount; i++) {
            Bridge bridge = new Bridge(new Random().nextBoolean());
            bridges.add(bridge);
        }
        return new Line(bridges);
    }
}
