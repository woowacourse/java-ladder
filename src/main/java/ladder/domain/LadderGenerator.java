package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LadderGenerator {
    private static final Random random = new Random();

    public Ladder generate(LadderWidth width, LadderHeight height) {
        List<Row> rows = new ArrayList<>();
        int ladderWidth = width.getLadderWidth();
        int ladderHeight = height.getLadderHeight();

        for (int i = 0; i < ladderHeight; i++) {
            rows.add(generateRow(ladderWidth));
        }
        return new Ladder(rows);
    }

    private Row generateRow(int width) {
        List<Foothold> footholds = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            addNextFoothold(footholds);
        }
        return Row.of(footholds, width);
    }

    private void addNextFoothold(List<Foothold> footholds) {
        if (footholds.isEmpty() || isLastSlotEmpty(footholds)) {
            footholds.add(Foothold.from(random.nextBoolean()));
            return;
        }

        footholds.add(Foothold.N);
    }

    private boolean isLastSlotEmpty(List<Foothold> footholds) {
        if (footholds.isEmpty()) {
            return false;
        }

        return footholds.get(footholds.size() - 1) == Foothold.N;
    }
}
