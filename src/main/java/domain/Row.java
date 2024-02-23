package domain;

import static domain.Names.MAX_NAMES_COUNT;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

class Row {
    static final int MIN_BRIDGES_COUNT = 1;
    static final int MAX_BRIDGES_COUNT = MAX_NAMES_COUNT - 1;

    private final List<Boolean> bridges;

    Row(List<Boolean> bridges) {
        validateBridgesCount(bridges);
        IntStream.range(1, bridges.size())
                .forEach(index -> validateNearBridge(bridges, index));
        this.bridges = Collections.unmodifiableList(bridges);
    }

    List<Boolean> getBridges() {
        return bridges;
    }

    private void validateBridgesCount(List<Boolean> bridges) {
        if (bridges.size() < MIN_BRIDGES_COUNT || bridges.size() > MAX_BRIDGES_COUNT) {
            throw new LadderGameException(ExceptionType.ROW_BRIDGES_COUNT);
        }
    }

    private void validateNearBridge(List<Boolean> bridges, int index) {
        if (bridges.get(index) && bridges.get(index - 1)) {
            throw new LadderGameException(ExceptionType.ROW_NEAR);
        }
    }
}
