package domain;

import domain.booleangenerator.BooleanGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Bridge> bridges = new ArrayList<>();

    public Line(int playersCount, BooleanGenerator booleanGenerator) {
        generate(playersCount, booleanGenerator);
    }

    private void generate(int playersCount, BooleanGenerator booleanGenerator) {
        for (int position = 0; position < playersCount - 1; position++) {
            makePoint(booleanGenerator);
        }
    }

    private void makePoint(BooleanGenerator booleanGenerator) {
        if (bridges.isEmpty() || isPreviousBridgeBlank()) {
            makeBridge(booleanGenerator);
            return;
        }
        addBlankBridge();
    }

    private boolean isPreviousBridgeBlank() {
        return !bridges.get(getBridgeCount() - 1).isExist();
    }

    private void addBlankBridge() {
        bridges.add(Bridge.BLANK);
    }

    private void makeBridge(BooleanGenerator booleanGenerator) {
        if (booleanGenerator.generate()) {
            bridges.add(Bridge.EXIST);
            return;
        }
        addBlankBridge();
    }

    public int getBridgeCount() {
        return bridges.size();
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
