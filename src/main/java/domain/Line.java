package domain;

import java.util.Collections;
import java.util.List;

public class Line {

    private List<Boolean> bridges;

    public Line(List<Boolean> bridges) {

        validateBridges(bridges);

        this.bridges = Collections.unmodifiableList(bridges);
    }

    private void validateBridges(List<Boolean> bridges) {
        for (int i = 0; i < bridges.size() - 1; i++) {
            Boolean currentBridge = bridges.get(i);
            Boolean nextBridge = bridges.get(i + 1);
            validateNotSerial(currentBridge, nextBridge);
        }
    }

    private void validateNotSerial(Boolean currentBridge, Boolean nextBridge) {
        if (currentBridge.equals(true) && currentBridge.equals(nextBridge)) {
            throw new IllegalArgumentException("브릿지는 연속으로 생성될 수 없습니다");
        }
    }

    public List<Boolean> getBridges() {
        return bridges;
    }
}
