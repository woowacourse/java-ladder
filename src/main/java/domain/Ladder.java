package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Row> rows = new ArrayList<>();

    public Ladder(int height, int width) {
        validateHeight(height);
        validateWidth(width);
        for (int index = 0; index < height; index++) {
            List<Boolean> rowInfo = RowInfoGenerator.generate(width - 1);
            Row row = new Row(rowInfo);
            rows.add(row);
        }
    }

    private static void validateHeight(int height) {
        if (height < 5 || height > 10) {
            throw new RuntimeException("사다리 높이는 5이상 10 이하여야 합니다.");
        }
    }

    private static void validateWidth(int width) {
        if (width < 2 || width > 10) {
            throw new RuntimeException("사다리 전체 폭은 2이상 10 이하여야 합니다.");
        }
    }

    public List<Row> getRows() {
        return Collections.unmodifiableList(rows);
    }
}
