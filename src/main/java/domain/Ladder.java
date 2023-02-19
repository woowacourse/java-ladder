package domain;

import java.util.ArrayList;
import java.util.List;
import util.BooleanGenerator;
import util.RandomBooleanGenerator;

public class Ladder {
    private final List<Line> lines;

    private Ladder() {
        this.lines = new ArrayList<>();
    }

    public static Ladder generateRandomly(Height height, int personCount) {
        Ladder ladder = new Ladder();
        ladder.generate(new RandomBooleanGenerator(), height.getHeight(), personCount);
        return ladder;
    }

    private void generate(BooleanGenerator booleanGenerator, int height, int personCount) {
        for (int index = 0; index < height; index++) {
            lines.add(Line.generateWithBridges(booleanGenerator, personCount));
        }
    }

    public int calculateTotalHeight() {
        return lines.size();
    }

    public List<Line> getLines() {
        return lines;
    }
}
