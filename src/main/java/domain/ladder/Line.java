package domain.ladder;

import domain.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Bridge> bridges = new ArrayList<>();

    public Line(int personCount, BooleanGenerator booleanGenerator) {
        createBridges(personCount, booleanGenerator);
    }

    private void createBridges(int personCount, BooleanGenerator booleanGenerator) {
        int bridgesSize = personCount - 1;
        for (int index = 0; index < bridgesSize; index++) {
            addBridge(index, booleanGenerator.generate());
        }
    }

    private void addBridge(int index, boolean flag) {
        BridgeJudge bridgeJudge = new BridgeJudge();
        if (bridgeJudge.canMake(bridges, flag, index)) {
            bridges.add(Bridge.PASSABLE);
            return;
        }
        bridges.add(Bridge.BLOCKED);
    }

    public List<Bridge> getBridges() {
        return bridges;
    }
}
