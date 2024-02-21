package model;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {

    private final int maxWidth;
    private final List<Boolean> lines;

    public LadderRow(int participantsSize) {
        this.maxWidth = participantsSize - 1;
        this.lines = new ArrayList<>();
    }


    public void crossLine(boolean line) {
        if (lines.size() == maxWidth - 1 && line) {
            lines.add(true);
            return;
        }
        lines.add(line);
        if (line) {
            lines.add(false);
        }
    }

    public int getMaxWidth() {
        return maxWidth;
    }

    public int currentWidthSize() {
        return lines.size();
    }

    public List<Boolean> getLines() {
        return lines;
    }
}
