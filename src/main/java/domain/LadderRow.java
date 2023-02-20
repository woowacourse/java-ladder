package domain;

import java.util.Collections;
import java.util.List;

public class LadderRow {
    private final List<Boolean> bars;

    public LadderRow(List<Boolean> bars) {
        validate(bars);
        this.bars = bars;
    }

    private void validate(List<Boolean> bars) {
        int limit = bars.size() - 1;
        for (int i = 0; i < limit; i++) {
            Boolean current = bars.get(i);
            Boolean next = bars.get(i + 1);
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
