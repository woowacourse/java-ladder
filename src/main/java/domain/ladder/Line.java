package domain.ladder;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.unmodifiableList;

public class Line {
    private final BridgeMakingStrategy makingStrategy;
    private final List<Bridge> bridges = new ArrayList<>();

    public Line(final int width, final BridgeMakingStrategy makingStrategy) {
        this.makingStrategy = makingStrategy;
        makeLine(width);
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
        return makingStrategy.getOne();
    }

    private boolean doesBridgeExistAtLast() {
        if (this.bridges.size() == 0) {
            return false;
        }
        return Bridge.EXIST == this.bridges.get(this.bridges.size() - 1);
    }

    public List<Bridge> getBridges() {
        return unmodifiableList(this.bridges);
    }

    public int getWidth() {
        return this.bridges.size();
    }
}
