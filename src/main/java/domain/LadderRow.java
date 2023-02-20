package domain;

import java.util.Collections;
import java.util.List;

public class LadderRow {
    List<Boolean> bars;

    public LadderRow(List<Boolean> lines) {
        validate(lines);
        this.bars = lines;
    }

    private void validate(List<Boolean> lines) {
        int limit = lines.size() - 1;
        for (int i = 0; i < limit; i++) {
            Boolean current = lines.get(i);
            Boolean next = lines.get(i + 1);
            checkIsTruContinuously(current, next);
        }
    }

    private void checkIsTruContinuously(Boolean current, Boolean next) {
        if (isAllTrue(current, next)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isAllTrue(Boolean current, Boolean next) {
        return current == next && current;
    }

    public List<Boolean> getBars() {
        return Collections.unmodifiableList(bars);
    }
}
