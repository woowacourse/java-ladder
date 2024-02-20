package ladder.model;

import java.util.List;

public class Line {
    private final List<Boolean> rows;

    public Line(List<Boolean> rows) {
        this.rows = rows;
    }

    public boolean isLeftLadderExist(int position) {
        if (position == 0) {
            return false;
        }
        return rows.get(position - 1);
    }
}
