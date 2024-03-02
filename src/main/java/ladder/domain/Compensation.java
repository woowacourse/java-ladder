package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Compensation {
    private final List<String> compensations;

    public Compensation(List<String> compensations, int size) {
        validateSize(compensations, size);
        this.compensations = Collections.unmodifiableList(compensations);
    }

    private void validateSize(List<String> compensations, int size) {
        if (compensations.size() != size) {
            throw new IllegalArgumentException("크기가 일치하지 않습니다.");
        }
    }

    public String get(int index) {
        return compensations.get(index);
    }

    public List<String> getAll() {
        return compensations;
    }
}
