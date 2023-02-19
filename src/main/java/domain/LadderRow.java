package domain;

import static utils.constants.ErrorMessages.CONSECUTIVE_LINE;

import java.util.Collections;
import java.util.List;

public class LadderRow {

    private final List<Line> lines;

    public LadderRow(final List<Line> lines) {
        validate(lines);
        this.lines = lines;
    }

    private void validate(final List<Line> lines) {
        for (int i = 0; i < lines.size() - 1; i++) {
            isAllExist(lines.get(i), lines.get(i + 1));
        }
    }

    private void isAllExist(Line current, Line next) {
        if (current == Line.EXIST && next == Line.EXIST) {
            throw new IllegalArgumentException(CONSECUTIVE_LINE.getMessage());
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
