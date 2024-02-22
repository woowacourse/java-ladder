package model;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {

    private final List<Boolean> lineStatus;

    public LadderRow(List<Boolean> lineStatus) {
        checkContinuousLine(lineStatus);
        this.lineStatus = new ArrayList<>(lineStatus);
    }

    public void checkContinuousLine(List<Boolean> lineStatus) {
        for (int i = 1; i < lineStatus.size(); i++) {
            removeContinuousLine(lineStatus, i);
        }
    }

    private void removeContinuousLine(List<Boolean> lineStatus, int index) {
        if (lineStatus.get(index) && lineStatus.get(index - 1)) {
            lineStatus.set(index, false);
        }
    }

    public List<Boolean> getLineStatus() {
        return lineStatus;
    }
}
