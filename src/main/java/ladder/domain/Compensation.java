package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Compensation {
    private final List<String> compensations;

    public Compensation(List<String> compensations) {
        this.compensations = Collections.unmodifiableList(compensations);
    }

    public String get(int index) {
        return compensations.get(index);
    }

    public List<String> getAll() {
        return compensations;
    }
}
