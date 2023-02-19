package domain;

import java.util.List;

import static java.util.List.copyOf;

public class Line {

    private final List<BridgeStatus> bridges;

    public Line(final List<BridgeStatus> bridges) {

        validateBridges(bridges);

        this.bridges = copyOf(bridges);
    }

    private void validateBridges(final List<BridgeStatus> bridgeStatuses) {
        for (int i = 0; i < bridgeStatuses.size() - 1; i++) {
            BridgeStatus currentBridgeStatus = bridgeStatuses.get(i);
            BridgeStatus nextBridgeStatus = bridgeStatuses.get(i + 1);
            validateNotSerial(currentBridgeStatus, nextBridgeStatus);
        }
    }

    private void validateNotSerial(final BridgeStatus currentBridgeStatus, final BridgeStatus nextBridgeStatus) {
        if (isSerial(currentBridgeStatus, nextBridgeStatus)) {
            throw new IllegalArgumentException("브릿지는 연속으로 생성될 수 없습니다");
        }
    }

    private boolean isSerial(final BridgeStatus currentBridgeStatus, final BridgeStatus nextBridgeStatus) {
        return currentBridgeStatus == BridgeStatus.EXIST && nextBridgeStatus == BridgeStatus.EXIST;
    }

    public List<BridgeStatus> getBridges() {
        return bridges;
    }

    public boolean hasRightBridge(int index) {
        return index < bridges.size() && bridges.get(index) != BridgeStatus.EMPTY;
    }

    public boolean hasLeftBridge(int index) {
        return index - 1 >= 0 && bridges.get(index - 1) != BridgeStatus.EMPTY;
    }
}
