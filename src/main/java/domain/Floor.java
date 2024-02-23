package domain;

import common.exception.message.ExceptionMessage;
import common.exception.model.ValidationException;

import java.util.Collections;
import java.util.List;

public class Floor {
    private final List<LadderBridge> bridges;

    public Floor(List<LadderBridge> bridges) {
        validateBridgesNotExistSerially(bridges);
        this.bridges = bridges;
    }

    private void validateBridgesNotExistSerially(List<LadderBridge> bridges) {
        LadderBridge before = bridges.get(0);
        for (int i = 1; i < bridges.size(); i++) {
            compareBridgeStatus(before, bridges.get(i));
        }
    }

    private void compareBridgeStatus(LadderBridge before, LadderBridge now) {
        if(now.equals(before) && now.equals(LadderBridge.BRIDGE)) {
            throw new ValidationException(ExceptionMessage.SERIAL_LADDER_BRIDGE);
        }
    }

    public List<LadderBridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
