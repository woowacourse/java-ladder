package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {
    private List<Integer> row;
    private int width;

    public LadderRow() {
        this(0);
    }

    public LadderRow(int width) {
        row = new ArrayList<>();
        this.width = width;
    }

    public void draw() {
        if (this.width < 2) {
            throw new IllegalArgumentException();
        }
        row.add(1);
        row.add(-1);
        this.width -= 2;
    }

    public void skip() {
        row.add(0);
        this.width -= 1;
    }

    public List<Integer> status() {
        return row;
    }
}
