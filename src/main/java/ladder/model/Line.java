package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private static final String VERTICAL_LINE = "|";
    private static final int ONE = 1;
    private List<Bridge> bridges;

    public Line(int countOfPlayer) {
        this.bridges = new ArrayList<>();
        this.bridgesInit(countOfPlayer);
    }

    public int lineSize() {
        return this.bridges.size();
    }

    public void checkLineValid() {
        for (int i = 0; i < this.lineSize(); i++) {
            this.getBridgeByIndex(i).isValidBridge();
        }
    }

    int move(int position) {
        return this.getBridgeByIndex(position).move();
    }

    private void bridgesInit(int countOfPlayer) {
        Bridge previousBridge = Bridge.firstBridge();
        bridges.add(previousBridge);

        for (int i = 1; i < countOfPlayer - ONE; i++) {
            bridges.add(Bridge.nextBridge(previousBridge));
            previousBridge = bridges.get(i);
        }
        bridges.add(Bridge.lastBridge(previousBridge));
    }

    private Bridge getBridgeByIndex(int index) {
        return this.bridges.get(index);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(VERTICAL_LINE);
        for (int i = 0; i < lineSize() - 1; i++) {
            stringBuilder.append(this.getBridgeByIndex(i)).append(VERTICAL_LINE);
        }
        return stringBuilder.toString();
    }
}
