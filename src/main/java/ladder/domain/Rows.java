package ladder.domain;

import java.util.List;

public class Rows {
    private final List<Row> rows;

    public Rows(List<Row> rows) {
        this.rows = rows;
    }

    public List<Row> getRows() {
        return rows;
    }
}
