package domain;

import java.util.Collections;
import java.util.List;

public class Floor {
    private final List<LadderBridge> bridges;

    public Floor(List<LadderBridge> bridges) {
        this.bridges = bridges;
    }

    public List<LadderBridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
