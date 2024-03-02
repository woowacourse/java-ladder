package domain.ladder;

import domain.ExceptionType;
import domain.LadderGameException;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Row {
    private static final int MIN_BRIDGES_COUNT = 1;
    private static final int MAX_BRIDGES_COUNT = 9;

    private final List<Bridge> bridges;

    public Row(List<Bridge> bridges) {
        validateBridgesCount(bridges);
        validateNearBridge(bridges);
        this.bridges = bridges;
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }

    private void validateBridgesCount(List<Bridge> bridges) {
        if (bridges.size() < MIN_BRIDGES_COUNT || bridges.size() > MAX_BRIDGES_COUNT) {
            throw new LadderGameException(ExceptionType.INVALID_BRIDGES_RANGE);
        }
    }

    private void validateNearBridge(List<Bridge> bridges) {
        IntStream.range(1, bridges.size()).forEach(index -> {
            if (bridges.get(index) == Bridge.EXIST && bridges.get(index - 1) == Bridge.EXIST) {
                throw new LadderGameException(ExceptionType.NOT_ALLOW_NEAR_BRIDGE);
            }
        });
    }
}
