package domain;

import java.util.Collections;
import java.util.List;

public class Bridges {

    private final List<Bridge> bridges;

    public Bridges(List<Bridge> bridges) {
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

    public List<Bridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
