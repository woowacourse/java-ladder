package domain.ladder;

import domain.generator.BooleanGenerator;
import utils.ErrorMessage;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int BRIDGES_MIN_SIZE = 1;
    private static final int BRIDGES_MAX_SIZE = 49;

    private List<Boolean> bridges = new ArrayList<>();

    public Line(int personCount, BooleanGenerator booleanGenerator) {
        validate(personCount);
        createBridges(personCount, booleanGenerator);
    }

    private void validate(int personCount) {
        int bridgeSize = personCount - 1;
        if (bridgeSize < BRIDGES_MIN_SIZE || bridgeSize > BRIDGES_MAX_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.PLAYER_SIZE_ERROR.getMessage());
        }
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
