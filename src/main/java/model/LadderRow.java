package model;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {

    private final List<Boolean> isLines;

    public LadderRow(List<Boolean> isLines) {
        checkContinuousLine(isLines);
        this.isLines = new ArrayList<>(isLines);
    }

    public void checkContinuousLine(List<Boolean> isLines) {
        for (int i = 1; i < isLines.size(); i++) {
            removeContinuousLine(isLines, i);
        }
    }

    private void removeContinuousLine(List<Boolean> isLines, int index) {
        if (isLines.get(index) && isLines.get(index - 1)) {
            isLines.set(index, false);
        }
    }

    public List<Boolean> getIsLines() {
        return isLines;
    }
}
