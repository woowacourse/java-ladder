package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final String EMPTY_LINE = "     ";
    private static final String FILLED_LINE = "-----";
    private static final String VERTICAL_LINE = "|";
    private static final int MOVE_LEFT = -1;
    private static final int MOVE_RIGHT = 1;
    private static final int MOVE_NONE = 0;
    private static final int ONE = 1;
    private List<Bridge> bridges;

    public Line(int countOfPlayer) {
        this.bridgesInit(countOfPlayer);
    }

    public int lineSize() {
        return this.bridges.size();
    }

    public void checkLineValid() {
        for (int i = 1; i < this.lineSize(); i++) {
            int previousBridgeIndex = i - ONE;
            int currentBridgeIndex = i;
            checkLineContinued(previousBridgeIndex, currentBridgeIndex);
        }
    }

    int move(int position) {
        if (this.canMoveLeft(position)) {
            return MOVE_LEFT;
        }
        if (this.canMoveRight(position)) {
            return MOVE_RIGHT;
        }
        return MOVE_NONE;
    }

    private void bridgesInit(int countOfPlayer) {
        this.bridges = new ArrayList<>();
        Bridge previousBridge = Bridge.firstBridge();
        bridges.add(previousBridge);
        for (int i = 1; i < countOfPlayer - ONE; i++) {
            bridges.add(Bridge.nextBridge(previousBridge));
            previousBridge = bridges.get(i);
        }
        this.checkLineValid();
    }

    private Bridge getBridgeByIndex(int index) {
        return this.bridges.get(index);
    }

    private void checkLineContinued(int previousBridgeIndex, int currentBridgeIndex) {
        if (this.getBridgeByIndex(previousBridgeIndex).isBridgesConnected(this.getBridgeByIndex(currentBridgeIndex))) {
            throw new IllegalArgumentException("이어지는 가로라인 발생");
        }
    }

    private boolean canMoveLeft(int position) {
        return position > 0 && this.getBridgeByIndex(position - ONE).isConnect();
    }

    private boolean canMoveRight(int position) {
        return position < this.lineSize() && this.getBridgeByIndex(position).isConnect();
    }

    private String getOne(int pointIndex) {
        if (this.getBridgeByIndex(pointIndex).isConnect()) {
            return FILLED_LINE;
        }
        return EMPTY_LINE;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(VERTICAL_LINE);
        for (int i = 0; i < lineSize(); i++) {
            stringBuilder.append(this.getOne(i)).append(VERTICAL_LINE);
        }
        return stringBuilder.toString();
    }
}
