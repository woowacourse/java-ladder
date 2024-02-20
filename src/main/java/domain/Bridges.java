package domain;

import java.util.Collections;
import java.util.List;

public class Bridges {

    private final List<Boolean> brides;

    public Bridges(List<Boolean> brides) {
        // TODO 추후 검증
        this.brides = brides;
    }

    public List<Boolean> getBridges() {
        return Collections.unmodifiableList(brides);
    }
}
