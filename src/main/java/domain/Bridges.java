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
        boolean before = false;
        for (Boolean bridge : bridges) {
            if (before && bridge) { // TODO 인텐트 처리
                throw new IllegalArgumentException();
            }
            before = bridge;
        }
    }

    public List<Boolean> getBridges() {
        return Collections.unmodifiableList(bridges);
    }
}
