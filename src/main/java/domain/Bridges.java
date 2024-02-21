package domain;

import java.util.Collections;
import java.util.List;

public class Bridges {

    private final List<Boolean> bridges;

    public Bridges(List<Boolean> bridges) {
        validate(bridges);
        this.bridges = bridges;
    }

    private void validate(List<Boolean> bridges) {
        boolean previous = false;
        for (Boolean current : bridges) {
            validateNotContinuousBridge(previous, current);
            previous = current;
        }
    }

    private void validateNotContinuousBridge(boolean before, Boolean bridge) {
        if (before && bridge) {
            throw new IllegalArgumentException();
        }
    }

    public List<Boolean> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
