package domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> bridges;

    public Line(int personCount) {
        this.bridges = new ArrayList<>();
        for (int index = 0; index < personCount - 1; index++) {
            bridges.add(false);
        }
    }
}
