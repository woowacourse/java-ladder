package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random random = new Random();
    private final List<Bridge> bridges = new ArrayList<>();

    public Line(final int width) {
        makeLine(width);
    }

    public List<Bridge> getBridges() {
        return this.bridges;
    }

    private void makeLine(final int width) {
        for (int i = 0; i < width; i++) {
            this.bridges.add(makeBridge());
        }
    }

    private Bridge makeBridge() {
        if (doesBridgeExistAtLast()) {
            return Bridge.EMPTY;
        }
        if (random.nextBoolean()) {
            return Bridge.EXIST;
        }
        return Bridge.EMPTY;
    }

    private boolean doesBridgeExistAtLast() {
        if (this.bridges.size() == 0) {
            return false;
        }
        return Bridge.EXIST == this.bridges.get(this.bridges.size() - 1);
    }
}
