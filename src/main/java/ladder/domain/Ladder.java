package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private int width;
    private int height;
    private List<LadderRow> rows;

    public Ladder(int width, int height) {
        rows = new ArrayList<>();
        this.width = width;
        this.height = height;
    }

    public void row() {
        for (int i = 0; i < this.height; ++i) {
            rows.add(new LadderRow(this.width).getRow());
        }
    }

    public LadderRow status(int index) {
        return rows.get(index);
    }

    public void row(TempInput tempInput) {
        for (int i = 0; i < this.height; i++) {
            rows.add(new LadderRow(this.width, tempInput).getRow());
        }
    }
}
