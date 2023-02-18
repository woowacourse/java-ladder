package domain;

import static utils.constants.ErrorMessages.CONSECUTIVE_LINE;

import java.util.Collections;
import java.util.List;

public class LadderRow {

    private final List<Boolean> lines;

    public LadderRow(final List<Boolean> lines) {
        validate(lines);
        this.lines = lines;
    }

    private void validate(final List<Boolean> lines) {
        for (int i = 0; i < lines.size() - 1; i++) {
            isAllTrue(lines.get(i), lines.get(i + 1));
        }
    }

    private void isAllTrue(boolean current, boolean next) {
        if (current && next) {
            throw new IllegalArgumentException(CONSECUTIVE_LINE.getMessage());
        }
    }

    public List<Boolean> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
