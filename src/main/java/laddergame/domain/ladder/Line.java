package laddergame.domain.ladder;

import laddergame.domain.result.Trace;
import laddergame.domain.bridge.Bridge;
import laddergame.domain.bridge.BridgeGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private final List<Bridge> bridges;

    public Line(final List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public static Line create(final LineSize lineSize, final BridgeGenerator bridgeGenerator) {
        final List<Bridge> bridges = new ArrayList<>();

        while (lineSize.isBiggerThan(bridges.size())) {
            bridges.add(generateBridge(bridges, bridgeGenerator));
        }

        return new Line(bridges);
    }

    private static Bridge generateBridge(final List<Bridge> bridges, final BridgeGenerator bridgeGenerator) {
        if (bridges.isEmpty()) {
            return bridgeGenerator.generate();
        }

        final Bridge lastBridge = bridges.get(bridges.size() - 1);
        if (lastBridge.isExist()) {
            return Bridge.EMPTY;
        }

        return bridgeGenerator.generate();
    }

    public Trace move(final Trace trace) {
        if (canMoveLeft(trace)) {
            return trace.moveLeft();
        }

        if (canMoveRight(trace)) {
            return trace.moveRight();
        }

        return trace;
    }

    private boolean canMoveLeft(final Trace trace) {
        if (trace.getPosition() == 0) {
            return false;
        }

        return hasBridge(trace.getPosition() - 1);
    }

    private boolean canMoveRight(final Trace trace) {
        if (trace.getPosition() == this.bridges.size()) {
            return false;
        }

        return hasBridge(trace.getPosition());
    }

    private boolean hasBridge(int position) {
        return bridges.get(position).isExist();
    }

    public List<Boolean> getBridgesState() {
        return bridges.stream()
                .map(Bridge::isExist)
                .toList();
    }
}
