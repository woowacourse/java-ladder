package model;

import java.util.List;

public class Line {
    private final List<Bridge> bridges;

    public Line(List<Boolean> bridges) {
        this.bridges = bridges.stream()
                .map(Bridge::new)
                .toList();
    }
}
