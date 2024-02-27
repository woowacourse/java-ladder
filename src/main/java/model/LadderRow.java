package model;

import java.util.List;

public class LadderRow {

    private final List<Boolean> isLines;

    public LadderRow(List<Boolean> isLines) {
        validateLadderRow(isLines);
        this.isLines = isLines;
    }

    private void validateLadderRow(List<Boolean> isLines) {
        for (int i = 1; i < isLines.size(); i++) {
            isConsecutiveTrue(isLines, i);
        }
    }

    private static void isConsecutiveTrue(List<Boolean> isLines, int index) {
        if (isLines.get(index - 1) && isLines.get(index)) {
            throw new IllegalStateException("연속된 true 값이 존재하면 안됩니다");
        }
    }
}
