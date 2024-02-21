package domain;

import java.util.Collections;
import java.util.List;

public class Bridges {

    private final List<BridgeStatus> bridges;

    public Bridges(List<BridgeStatus> bridges) {
        validate(bridges);
        this.bridges = bridges;
    }

    private void validate(List<BridgeStatus> bridges) {
        BridgeStatus previous = BridgeStatus.EMPTY;
        for (BridgeStatus current : bridges) {
            validateNotContinuousBridge(previous, current);
            previous = current;
        }
    }

    private void validateNotContinuousBridge(BridgeStatus previous, BridgeStatus current) {
        if (previous == BridgeStatus.BUILT
                && current == BridgeStatus.BUILT) {
            throw new IllegalArgumentException("다리는 연속해서 놓을 수 없습니다.");
        }
    }

    public List<BridgeStatus> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
