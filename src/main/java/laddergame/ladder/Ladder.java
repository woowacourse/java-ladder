package laddergame.ladder;

import laddergame.vo.Position;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

public class Ladder {
    private final List<Row> rows;

    public Ladder(List<Row> rows) {
        validateRowsLengthAllEqual(rows);
        this.rows = new ArrayList<>(rows);
    }

    private void validateRowsLengthAllEqual(List<Row> rows) {
        if (isAllRowsLengthNotEqual(rows)) {
            throw new IllegalArgumentException("사다리 길이가 균일하지 않습니다.");
        }
    }

    private boolean isAllRowsLengthNotEqual(List<Row> rows) {
        return rows.stream()
                   .mapToInt(Row::getWidth)
                   .distinct()
                   .count() > 1;
    }

    public Position climbDownFrom(Position initialPosition) {
        Position currentPosition = initialPosition;
        for (Row row : rows) {
            currentPosition = row.movePlayer(currentPosition);
        }
        return currentPosition;
    }

    public List<List<Foothold>> getFootholdsMap() {
        return rows.stream()
                   .map(Row::getFootholds)
                   .collect(toUnmodifiableList());
    }

    public int getHeight() {
        return rows.size();
    }

    public int getWidth() {
        return rows.get(0)
                   .getWidth();
    }
}
