package domain;

import static java.util.List.copyOf;

import java.util.List;

public class Line {

    private final List<Bridge> bridges;

    public Line(final List<Bridge> bridges) {
        validateBridges(bridges);
        this.bridges = copyOf(bridges);
    }

    private void validateBridges(final List<Bridge> bridges) {
        for (int i = 0; i < bridges.size() - 1; i++) {
            Bridge currentBridge = bridges.get(i);
            Bridge nextBridge = bridges.get(i + 1);
            validateNotSerial(currentBridge, nextBridge);
        }
    }

    private void validateNotSerial(final Bridge currentBridge, final Bridge nextBridge) {
        if (currentBridge.isSerialWith(nextBridge)) {
            throw new IllegalArgumentException("연속인 브릿지가 존재합니다");
        }
    }

    public List<Bridge> getBridges() {
        return bridges;
    }

    public int findPositionAfter(final int currentPosition) {
        if (isMovable(currentPosition - 1)) {
            if (getLeftBridgeFrom(currentPosition).doesExist()) {
                return currentPosition - 1;
            }
        }

        if (isMovable(currentPosition + 1)) {
            if (getRightBridgeFrom(currentPosition).doesExist()) {
                return currentPosition + 1;
            }
        }

        return currentPosition;
    }

    private Bridge getLeftBridgeFrom(int currentPosition) {
        return bridges.get(currentPosition - 1);
    }

    private Bridge getRightBridgeFrom(int currentPosition) {
        return bridges.get(currentPosition);
    }

    private boolean isMovable(final int position) {
        return 0 <= position && position <= bridges.size();
    }
}
