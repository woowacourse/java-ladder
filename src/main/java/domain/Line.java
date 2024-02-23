package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random random = new Random();
    private final List<Bridge> bridges = new ArrayList<>();

    public Line(final int width) {
        generateLine(width);
    }

    public List<Bridge> getBridges() {
        return this.bridges;
    }

    private void generateLine(final int width) {
        for (int i = 0; i < width; i++) {
            bridges.add(generateBridgeOne());
        }
    }

    private Bridge generateBridgeOne() {
        if (doesLastBridgeExist()) {
            return Bridge.EMPTY;
        }
        if (random.nextBoolean()) {
            return Bridge.EXIST;
        }
        return Bridge.EMPTY;
    }

    private boolean doesLastBridgeExist() {
        if (this.bridges.size() == 0) {
            return false;
        }
        return Bridge.EXIST == this.bridges.get(this.bridges.size() - 1);
    }
}
