package domain;

import java.util.ArrayList;
import java.util.List;
import util.BooleanGenerator;

public class Line {
    private final List<Boolean> bridges;

    public Line(int personCount) {
        this.bridges = new ArrayList<>();
        for (int index = 0; index < personCount - 1; index++) {
            bridges.add(false);
        }
    }

    public void generateBridge(BooleanGenerator booleanGenerator) {
        for (int bridgeIndex = 0; bridgeIndex < bridges.size(); bridgeIndex++) {
            bridges.set(bridgeIndex, booleanGenerator.generate());
        }
    }
}
