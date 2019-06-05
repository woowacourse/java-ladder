package ladderGame.model.ladder;

import java.util.ArrayList;
import java.util.List;

public class Row {
    private List<BridgePoint> bridgePoints;

    public Row(int columnNum) {
        bridgePoints = new ArrayList<BridgePoint>();
        for (int i = 0; i < columnNum; i++) {
            bridgePoints.add(new BridgePoint(false));
        }
    }

    public void draw(int column) {
        if (leftBridgePointisSetTrue(column) || rightBridgePointisSetTrue(column)) {
            return;
        }
        bridgePoints.get(column).setTrue();
    }

    private boolean leftBridgePointisSetTrue(int column) {
        return column > 0 && bridgePoints.get(column - 1).isTrue();

    }

    private boolean rightBridgePointisSetTrue(int column) {
        return column < bridgePoints.size() - 1 && bridgePoints.get(column + 1).isTrue();
    }

    public boolean getBridgePointExistence(int column) {
        return bridgePoints.get(column).isTrue();
    }

    public int getArrivalIndex(int startIndex) {
        if (startIndex > 0 && bridgePoints.get(startIndex - 1).isTrue()) {
            return startIndex - 1;
        }
        if (startIndex < bridgePoints.size() && bridgePoints.get(startIndex).isTrue()) {
            return startIndex + 1;
        }
        return startIndex;
    }

    public int getTrueBridgePointNumber() {
        return (int) bridgePoints.stream().filter(bridgePoint -> bridgePoint.isTrue()).count();
    }

}
