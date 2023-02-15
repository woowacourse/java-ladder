package domain;

import static java.util.List.*;

import java.util.List;

public class Line {

    private List<Bridge> bridges;

    public Line(List<Bridge> bridges) {

        validateBridges(bridges);

        this.bridges = copyOf(bridges);
    }

    private void validateBridges(List<Bridge> bridges) {
        for (int i = 0; i < bridges.size() - 1; i++) {
            Bridge currentBridge = bridges.get(i);
            Bridge nextBridge = bridges.get(i + 1);
            validateNotSerial(currentBridge, nextBridge);
        }
    }

    private void validateNotSerial(Bridge currentBridge, Bridge nextBridge) {
        if (isSerial(currentBridge, nextBridge)) {
            throw new IllegalArgumentException("브릿지는 연속으로 생성될 수 없습니다");
        }
    }

    private boolean isSerial(Bridge currentBridge, Bridge nextBridge) {
        return currentBridge == Bridge.EXIST && nextBridge == Bridge.EXIST;
    }

    public List<Bridge> getBridges() {
        return bridges;
    }
}
