package domain;

import java.util.Collections;
import java.util.List;

public class Line {
    private final List<LadderBridge> bridges;

    public Line(List<LadderBridge> bridges) {
        this.bridges = bridges;
    }

    public List<LadderBridge> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
