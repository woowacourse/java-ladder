package ladder.domain;


import java.util.List;

public class LadderRow {
    private List<LadderLine> row;

    public LadderRow(List<LadderLine> lines) {
        this.row = lines;
    }

    public List<LadderLine> status() {
        return row;
    }
}
