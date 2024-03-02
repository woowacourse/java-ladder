package domain.ladder;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Line {

    private final List<Bridge> bridges;

    public Line(List<Bridge> bridges) {
        validate(bridges);
        this.bridges = bridges;
    }

    private void validate(List<Bridge> bridges) {
        Bridge previous = Bridge.EMPTY;
        for (Bridge current : bridges) {
            validateNotContinuousBridge(previous, current);
            previous = current;
        }
    }

    private void validateNotContinuousBridge(Bridge previous, Bridge current) {
        if (previous == Bridge.BUILT
                && current == Bridge.BUILT) {
            throw new IllegalArgumentException("다리는 연속해서 놓을 수 없습니다.");
        }
    }

    public void moveAllMovableIndex(List<Integer> indexes) {
        IntStream.range(0, bridges.size())
                .filter(index -> bridges.get(index) == Bridge.BUILT)
                .forEach((bridgeIndex) -> Collections.swap(indexes, bridgeIndex, bridgeIndex + 1));
    }

    public int size() {
        return bridges.size();
    }

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
