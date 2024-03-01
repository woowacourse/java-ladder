package domain;

import java.util.List;

public class Position {

    private int value;


    public Position(final int value) {
        this.value = value;
    }

    public void moveHorizontally(final Line line) {
        final List<Bridge> bridges = line.getBridges();

        if (handleRight(bridges)) {
            return;
        }

        handleLeft(bridges);
    }

    private void handleLeft(final List<Bridge> bridges) {
        final boolean isNotFirstBridge = value > 0;

        if (isNotFirstBridge && bridges.get(value - 1).isConnected()) {
            moveLeft();
        }
    }

    private boolean handleRight(final List<Bridge> bridges) {
        final boolean isNotEndBridge = value < bridges.size();

        if (isNotEndBridge && bridges.get(value).isConnected()) {
            moveRight();
            return true;
        }

        return false;
    }

    private void moveLeft() {
        value = value - 1;
    }

    private void moveRight() {
        value = value + 1;
    }

    public int getValue() {
        return value;
    }
}
