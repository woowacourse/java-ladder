package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLadderGenerator {
    private static final Random random = new Random();

    public Ladder generateRows(Width width, Height height) {
        List<Row> rows = new ArrayList<>();
        int ladderWidth = width.getWidth();
        int ladderHeight = height.getHeight();

        for (int i = 0; i < ladderHeight; i++) {
            rows.add(generateValidRow(ladderWidth));
        }
        return new Ladder(rows);
    }

    private Row generateValidRow(int size) {
        try {
            return generateRow(size);
        } catch (IllegalArgumentException e) {
            return generateValidRow(size);
        }
    }

    private Row generateRow(int width) {
        List<Step> row = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            row.add(generateFoothold());
        }
        return Row.of(row, width);
    }

    private Step generateFoothold() {
        return Step.from(random.nextBoolean());
    }
}
