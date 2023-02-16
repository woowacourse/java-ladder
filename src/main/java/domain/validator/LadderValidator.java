package domain.validator;

import domain.Line;

import java.util.List;

public class LadderValidator {

    public static final int LINE_MIN_SIZE = 1;
    public static final int LINE_MAX_SIZE = 30;

    public static void validate(final List<Line> lines) {
        if (lines.size() < LINE_MIN_SIZE || lines.size() > LINE_MAX_SIZE) {
            throw new IllegalArgumentException("사다리의 높이는 1이상 30이하여야 합니다.");
        }
    }

}
