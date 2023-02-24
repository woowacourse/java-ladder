package laddergame.ladder;

import laddergame.vo.Position;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

public class Ladder {
    private final List<Row> rows;

    public Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public Position climbDownFrom(Position initialPosition) {
        Position currentPosition = initialPosition;
        for (Row row : rows) {
            currentPosition = row.movePlayer(currentPosition);
        }
        return currentPosition;
    }

    public List<Row> getRows() {
        return rows;
    }

    public List<List<Foothold>> getFootholdsMap() {
        return rows.stream()
                   .map(Row::getFootholds)
                   .collect(toUnmodifiableList());
    }
}
