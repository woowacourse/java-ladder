package domain;

import java.util.*;

public class Line {
    private final List<Bridge> bridges;

    public Line(final List<Bridge> bridges) {
        this.bridges = bridges;
    }

    public List<Bridge> getBridges() {
        return bridges;
    }
}
