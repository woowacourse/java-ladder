package domain.ladder;

import domain.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private List<Boolean> bridges = new ArrayList<>();

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
        if (BridgeJudge.canMake(bridges, flag, index)) {
            bridges.add(true);
            return;
        }
        bridges.add(false);
    }

    public List<Boolean> getBridges() {
        return bridges;
    }
}
