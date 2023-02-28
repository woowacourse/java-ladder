package domain;

import java.util.ArrayList;
import java.util.List;
import utils.RandomLineMaker;

public class Ladder {

    private final List<Line> lines = new ArrayList<>();
    private final Height height;

    private Ladder(Height height) {
        this.height = height;
    }

    public static Ladder of(Height height, int userCount) {
        Ladder ladder = new Ladder(height);
        ladder.addLine(userCount);

        return ladder;
    }

    private void addLine(int userCount) {
        RandomLineMaker randomLineMaker = new RandomLineMaker();

        for (int line = 0; line < height.getHeight(); line++) {
            lines.add(Line.of(randomLineMaker, userCount));
        }
    }

    public List<Line> getLines() {
        return lines;
    }

}
