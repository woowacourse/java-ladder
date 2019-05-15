package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public final class Line {
    private final List<Boolean> subLines;

    public Line(final List<Boolean> subLines) {
        validate(subLines);
        this.subLines = new ArrayList<>(subLines);
    }

    private void validate(List<Boolean> subLines) {
        validateSize(subLines);
        validateDuplication(subLines);
    }

    private void validateSize(List<Boolean> subLines) {
        if (subLines.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Boolean> subLines) {
        for (int i = 1; i < subLines.size(); i++) {
            if (subLines.get(i) && subLines.get(i - 1)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
