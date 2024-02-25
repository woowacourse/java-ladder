package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Compensation {
    private final List<String> compensations;

    public Compensation(List<String> compensations, int size) {
        validateSize(compensations, size);
        this.compensations = new ArrayList<>(compensations);
    }

    private void validateSize(List<String> compensations, int size) {
        if (compensations.size() != size) {
            throw new IllegalArgumentException("보상 갯수가 사람 수와 일치하지 않습니다");
        }
    }

    public String get(int index) {
        return compensations.get(index);
    }
}
