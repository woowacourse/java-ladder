package domain;

import java.util.*;
import java.util.stream.IntStream;

public class Line {
    private final List<Bridge> bridges;

    public Line(final List<Bridge> bridges) {
        validate(bridges);
        this.bridges = bridges;
    }

    private void validate(final List<Bridge> bridges) {
        IntStream.range(1, bridges.size()).forEach(index -> {
                    Bridge previousBridge = bridges.get(index - 1);
                    Bridge currentBridge = bridges.get(index);
                    validateOverlappingBridge(previousBridge, currentBridge);
                }
        );
    }

    private static void validateOverlappingBridge(final Bridge previousBridge, final Bridge currentBridge) {
        if (previousBridge.isConnected() && previousBridge == currentBridge) {
            throw new IllegalArgumentException("사다리 라인은 겹칠 수 없습니다.");
        }
    }

    public List<Bridge> getBridges() {
        return bridges;
    }

    public int getWidth() {
        return bridges.size();
    }

    public boolean checkConnectivity(final int position) {
        final Bridge bridge = bridges.get(position);
        return bridge.isConnected();
    }
}
