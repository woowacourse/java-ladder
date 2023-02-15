package domain;

import java.util.List;

public class LadderRow {
    List<Boolean> lines;

    public LadderRow(List<Boolean> lines) {
        this.lines = lines;
    }

    public List<Boolean> getLines() {
        return lines;
    }
}
