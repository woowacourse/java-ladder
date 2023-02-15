package domain;

import java.util.List;

public class Lines {

    public static final int LINE_MIN_SIZE = 1;
    public static final int LINE_MAX_SIZE = 30;

    public Lines(List<Line> lines) {
        validate(lines);
    }

    private void validate(List<Line> lines) {
        if (lines.size() < LINE_MIN_SIZE || lines.size() > LINE_MAX_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
