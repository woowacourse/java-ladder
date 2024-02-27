package domain.ladder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Floor {

    private static final int LEFTMOST = 0;

    private final List<Bridge> bridges;

    private Floor(List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public static Floor createByStrategy(final BridgeGenerator bridgeGenerator, final Width width) {
        List<Bridge> bridges = new ArrayList<>();

        while (bridges.size() < width.value()) {
            final Bridge bridgeCandidate = bridgeGenerator.generate();
            final Bridge previousBridge = findPreviousBridge(bridges);

            bridges.add(createBridge(bridgeCandidate, previousBridge));
        }
        return new Floor(bridges);
    }

    private static Bridge findPreviousBridge(List<Bridge> bridges) {
        if (bridges.isEmpty()) {
            return Bridge.NO_BRIDGE;
        }
        return bridges.get(bridges.size() - 1);
    }

    private static Bridge createBridge(final Bridge bridgeCandidate, final Bridge previousBridge) {
        if (previousBridge == Bridge.BRIDGE) {
            return Bridge.NO_BRIDGE;
        }
        return bridgeCandidate;
    }


    public int move(final int startPosition) {
        if (startPosition == LEFTMOST) {
            return tryMoveRight(startPosition);
        }

        final int rightmost = bridges.size();
        if (startPosition == rightmost) {
            return tryMoveLeft(startPosition);
        }

        return tryMoveLeftAndRight(startPosition);
    }

    private int tryMoveLeft(final int startPosition) {
        final int leftBridgeIndex = startPosition - 1;

        if (bridges.get(leftBridgeIndex) == Bridge.BRIDGE) {
            return startPosition - 1;
        }
        return startPosition;
    }

    private int tryMoveRight(final int startPosition) {
        final int rightBridgeIndex = startPosition;

        if (bridges.get(rightBridgeIndex) == Bridge.BRIDGE) {
            return startPosition + 1;
        }
        return startPosition;
    }

    private int tryMoveLeftAndRight(final int startPosition) {
        final int tryMoveLeftResult = tryMoveLeft(startPosition);
        if (tryMoveLeftResult == startPosition - 1) {
            return tryMoveLeftResult;
        }

        return tryMoveRight(startPosition);
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
