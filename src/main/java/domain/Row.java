package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Row {
    static final int MIN_BRIDGES_COUNT = 1;
    static final int MAX_BRIDGES_COUNT = 9;

    private final List<Boolean> bridges;

    Row(List<Boolean> bridges) {
        validateBridgesCount(bridges);
        IntStream.range(1, bridges.size())
                .forEach(index -> validateNearBridge(bridges, index));
        this.bridges = Collections.unmodifiableList(bridges);
    }

    public List<Boolean> getBridges() {
        return bridges;
    }

    private void validateBridgesCount(List<Boolean> bridges) {
        if (bridges.size() < MIN_BRIDGES_COUNT || bridges.size() > MAX_BRIDGES_COUNT) {
            throw new LadderGameException(ExceptionType.INVALID_BRIDGES_RANGE);
        }
    }

    private void validateNearBridge(List<Boolean> bridges, int index) {
        if (bridges.get(index) && bridges.get(index - 1)) {
            throw new LadderGameException(ExceptionType.NOT_ALLOW_NEAR_BRIDGE);
        }
    }
}
