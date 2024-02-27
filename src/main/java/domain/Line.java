package domain;

import domain.booleangenerator.BooleanGenerator;
import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Bridge> bridges;

    public Line(int playerCount, BooleanGenerator booleanGenerator) {
        bridges = new ArrayList<>();
        for (int position = 0; position < playerCount - 1; position++) {
            addBridge(booleanGenerator);
        }
    }

    private void addBridge(BooleanGenerator booleanGenerator) {
        if (bridges.isEmpty() || checkPreviousBlank()) {
            bridges.add(Bridge.from(booleanGenerator));
            return;
        }
        bridges.add(Bridge.BLANK);
    }

    private boolean checkPreviousBlank() {
        return bridges.get(getBridgeCount() - 1) == Bridge.BLANK;
    }

    public Bridge getBridge(int index) {
        return bridges.get(index);
    }

    public int getBridgeCount() {
        return bridges.size();
    }

    public List<Boolean> getBridgesInformation() {
        return bridges.stream().map(Bridge::toBoolean).toList();
    }

    public int getNextPosition(int position) {
        if (isMovableLeft(position)) {
            return position - 1;
        }
        if (isMovableRight(position)) {
            return position + 1;
        }
        return position;
    }

    private boolean isMovableLeft(int position) {
        return position != 0 && bridges.get(position - 1).toBoolean();
    }

    private boolean isMovableRight(int position) {
        return position != bridges.size() && bridges.get(position).toBoolean();
    }
}
