package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderRow {
    private List<Integer> row;

    public LadderRow() {
        row = new ArrayList<>();
    }

    public void draw() {
        row.add(1);
        row.add(-1);
    }

    public void skip() {
        row.add(0);
    }

    public List<Integer> status() {
        return row;
    }
}
