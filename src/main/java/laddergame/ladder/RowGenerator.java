package laddergame.ladder;

import laddergame.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class RowGenerator {
    private final BooleanGenerator booleanGenerator;

    public RowGenerator(BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public Row generate(int width) {
        List<Foothold> footholds = new ArrayList<>();

        for (int i = 0; i < width; i++) {
            decideNextSlot(footholds);
        }

        return Row.of(footholds, width);
    }

    private void decideNextSlot(List<Foothold> footholds) {
        if (isLastSlotFoothold(footholds)) {
            footholds.add(Foothold.BLOCKED);
            return;
        }

        Foothold next = Foothold.from(booleanGenerator.generate());
        footholds.add(next);
    }

    private boolean isLastSlotFoothold(List<Foothold> footholds) {
        return !footholds.isEmpty() &&
                footholds.get(footholds.size() - 1) == Foothold.PASSABLE;
    }
}
