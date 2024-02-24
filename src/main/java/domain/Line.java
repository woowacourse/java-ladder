package domain;

import domain.booleangenerator.BooleanGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private final List<Bridge> bridges = new ArrayList<>();

    public Line(Players players, BooleanGenerator booleanGenerator) {
        generate(players, booleanGenerator);
    }

    private void generate(Players players, BooleanGenerator booleanGenerator) {
        for (int position = 0; position < players.getTotalPlayerSize() - 1; position++) {
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
        return !Bridge.isExist(bridges.get(bridges.size() - 1));
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
