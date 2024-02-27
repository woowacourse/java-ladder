package domain;

import java.util.ArrayList;
import java.util.List;


public class Ladder {

    private final List<Row> rows;

    public Ladder(final int width, final int height) {
        validationHeight(height);

        LadderStrategy strategy = new RandomLadderStrategy();

        this.rows = new ArrayList<>();
        for (int i = 0; i < height; ++i) {
            rows.add(new Row(width, strategy));
        }
    }

    public int getResult(int index) {
        validationIndex(index);

        int position = index;
        for (Row row : rows) {
            position = row.goDown(position);
        }
        return position;
    }

    private void validationHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("높이는 1 이상이어야 한다.");
        }
    }

    private void validationIndex(int index) {
        if (index >= rows.size() || index < 0) {
            throw new IllegalArgumentException("위치는 0 이상 가로 길이 미만 이어야 한다.");
        }
    }
}
