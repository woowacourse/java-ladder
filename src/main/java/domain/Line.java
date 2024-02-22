package domain;

import domain.booleangenerator.BooleanGenerator;
import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Bridge> bridges;

    public Line(int playerCount, BooleanGenerator booleanGenerator) {
        bridges = new ArrayList<>();
        generate(playerCount, booleanGenerator);
    }

    private void generate(int playerCount, BooleanGenerator booleanGenerator) {
        for (int position = 0; position < playerCount - 1; position++) {
            makePoint(booleanGenerator);
        }
    }

    private void makePoint(BooleanGenerator booleanGenerator) {
        if (bridges.isEmpty() || checkPreviousBlank()) {
            makeBridge(booleanGenerator);
            return;
        }
        bridges.add(Bridge.BLANK);
    }

    private boolean checkPreviousBlank() {
        return bridges.get(bridges.size() - 1) == Bridge.BLANK;
    }

    private void makeBridge(BooleanGenerator booleanGenerator) {
        if (booleanGenerator.generate()) {
            bridges.add(Bridge.EXIST);
            return;
        }
        bridges.add(Bridge.BLANK);
    }

    public int getBridgeCount() {
        return bridges.size();
    }

    public List<Bridge> getBridges() {
        return bridges;
    }
}
