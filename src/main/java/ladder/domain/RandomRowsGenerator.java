package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomRowsGenerator {
    private static final Random random = new Random();

    public Rows generateRows(Width width, Height height) {
        List<Row> rows = new ArrayList<>();
        int ladderWidth = width.getWidth();
        int ladderHeight = height.getHeight();

        for (int i = 0; i < ladderHeight; i++) {
            rows.add(generateValidRow(ladderWidth));
        }
        return new Rows(rows);
    }

    private Row generateValidRow(int width) {
        try {
            return generateRow(width);
        } catch (IllegalArgumentException e) {
            return generateValidRow(width);
        }
    }

    private Row generateRow(int width) {
        List<Foothold> row = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            row.add(generateFoothold());
        }
        return Row.of(row, width);
    }

    private Foothold generateFoothold() {
        return Foothold.from(random.nextBoolean());
    }
}
