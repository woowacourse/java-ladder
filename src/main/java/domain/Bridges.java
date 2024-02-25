package domain;

import java.util.List;
import java.util.stream.IntStream;

public class Bridges {
    public static final int MIN_BRIDGES_COUNT = 1;
    public static final int MAX_BRIDGES_COUNT = 9;

    private final List<Boolean> bridges;

    public Bridges(List<Boolean> bridges) {
        validateBridgesCount(bridges);
        validateNearBridge(bridges);
        this.bridges = bridges;
    }

    private void validateBridgesCount(List<Boolean> bridges) {
        if (bridges.size() < MIN_BRIDGES_COUNT || bridges.size() > MAX_BRIDGES_COUNT) {
            throw new LadderGameException(ExceptionType.INVALID_BRIDGES_RANGE);
        }
    }

    private void validateNearBridge(List<Boolean> bridges) {
        IntStream.range(1, bridges.size()).forEach(index -> {
            if (bridges.get(index) && bridges.get(index - 1)) {
                throw new LadderGameException(ExceptionType.NOT_ALLOW_NEAR_BRIDGE);
            }
        });
    }

    public List<Boolean> getBridges() {
        return bridges;
    }
}
