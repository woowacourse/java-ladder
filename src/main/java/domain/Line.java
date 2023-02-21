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
            throw new IllegalArgumentException("연속된 가로 라인이 존재합니다");
        }
    }

    public Position findPositionAfter(final Position currentPosition) {
        if (getLeftBridgeFrom(currentPosition).doesExist()) {
            return currentPosition.left();
        }
        if (getRightBridgeFrom(currentPosition).doesExist()) {
            return currentPosition.right();
        }
        return currentPosition;
    }

    private Bridge getLeftBridgeFrom(Position position) {
        if (isValid(position.left())) {
            return getBridgeAt(position.left());
        }
        return Bridge.EMPTY;
    }

    private Bridge getRightBridgeFrom(Position position) {
        if (isValid(position.right())) {
            return getBridgeAt(position);
        }
        return Bridge.EMPTY;
    }

    private Bridge getBridgeAt(Position position) {
        return bridges.get(position.getPosition());
    }

    private boolean isValid(Position position) {
        return position.isInBetween(0, bridges.size());
    }

    public List<Bridge> getBridges() {
        return bridges;
    }
}
