package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Ladder {
    private final List<Row> rows = new ArrayList<>();

    Ladder(Height height, Width width, RowInfoGenerator rowInfoGenerator) {
        for (int index = 0; index < height.getLength(); index++) {
            List<Boolean> rowInfo = rowInfoGenerator.generate(width.getLength() - 1);
            Row row = new Row(rowInfo);
            rows.add(row);
        }
    }

    List<Row> getRows() {
        return Collections.unmodifiableList(rows);
    }
}
