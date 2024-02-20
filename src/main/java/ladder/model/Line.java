package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private final List<Boolean> row;

    private Line(List<Boolean> row) {
        this.row = row;
    }

    public static Line of(int playerCount) {
        List<Boolean> randomRow = new ArrayList<>();

        // TODO: Random 선택을 기반으로 생성해야 함.
        for (int i = 0; i < playerCount; i++) {
            randomRow.add(true);
        }

        return new Line(randomRow);
    }

    public boolean isLeftLadderExist(int position) {
        if (position == 0) {
            return false;
        }
        return row.get(position - 1);
    }

    public int size() {
        return row.size();
    }
}
