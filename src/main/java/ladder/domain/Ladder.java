package ladder.domain;

import java.util.List;

import static java.util.stream.Collectors.toUnmodifiableList;

public class Ladder {
    private final List<Row> rows;

    public Ladder(List<Row> rows) {
        this.rows = rows;
    }

    public List<Row> getRows() {
        return rows;
    }

    public List<List<Foothold>> getState() {
        return rows.stream()
                   .map(Row::getFootholds)
                   .collect(toUnmodifiableList());
    }
}
