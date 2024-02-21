package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Row> rows = new ArrayList<>();

    public Ladder(Height height, Width width) {
        for (int index = 0; index < height.getLength(); index++) {
            List<Boolean> rowInfo = RowInfoGenerator.generate(width.getLength() - 1);
            Row row = new Row(rowInfo);
            rows.add(row);
        }
    }

    public List<Row> getRows() {
        return Collections.unmodifiableList(rows);
    }
}
