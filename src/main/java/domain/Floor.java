package domain;

import common.exception.message.ExceptionMessage;
import common.exception.model.ValidationException;

import java.util.Collections;
import java.util.List;

public class Floor {
    private final List<LadderBridge> bridges;

    public Floor(List<LadderBridge> bridges) {
        validateIsBridgeSerial(bridges);
        this.bridges = bridges;
    }

    private void validateIsBridgeSerial(List<LadderBridge> bridges) {
        LadderBridge before = bridges.get(0);
        for (int i = 1; i < bridges.size(); i++) {
            isBridgeSerial(bridges, i, before);
        }
    }

    private void isBridgeSerial(List<LadderBridge> bridges, int i, LadderBridge before) {
        if(bridges.get(i).equals(before)) {
            throw new ValidationException(ExceptionMessage.SERIAL_LADDER_BRIDGE);
        }
    }

    public List<LadderBridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
