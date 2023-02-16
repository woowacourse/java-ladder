package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toUnmodifiableList;

public class Rows {
    private final List<Row> rows;

    public Rows(List<Row> rows) {
        this.rows = rows;
    }

    public List<Row> getRows() {
        return rows;
    }

    public List<List<Foothold>> getState() {
        return rows.stream()
                .map(Row::getRow)
                .collect(toUnmodifiableList());
    }
}
