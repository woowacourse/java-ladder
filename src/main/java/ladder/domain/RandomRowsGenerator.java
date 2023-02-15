package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomRowsGenerator {
    private static final Random random = new Random();

    public Row generateValidRow(int size) {
        try {
            return generateRow(size);
        } catch (IllegalArgumentException e) {
            return generateValidRow(size);
        }
    }

    private Row generateRow(int size) {
        List<Foothold> row = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            row.add(getFoothold());
        }
        return Row.of(row, size);
    }

    private Foothold getFoothold() {
        return Foothold.from(random.nextBoolean());
    }

    public Rows generateRows(int width, int height) {
        List<Row> rows = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            rows.add(generateValidRow(width));
        }
        return new Rows(rows);
    }
}
