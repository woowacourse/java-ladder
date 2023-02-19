package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import utils.NumberGenerator;

public class Ladder {

    private static final int NUMBER_OF_PEOPLE_TO_WIDTH_SCALE = 1;

    private final List<Line> lines;
    private final LadderHeight ladderHeight;

    private Ladder(List<Line> lines, LadderHeight ladderHeight) {
        this.lines = new ArrayList<>(lines);
        this.ladderHeight = ladderHeight;
    }

    public static Ladder create(int numberOfPeople,
                                LadderHeight ladderHeight,
                                NumberGenerator numberGenerator) {
        List<Line> lines = new ArrayList<>();
        int width = numberOfPeople - NUMBER_OF_PEOPLE_TO_WIDTH_SCALE;
        int height = ladderHeight.getLadderHeight();

        while (height -- > 0) {
            lines.add(Line.create(numberGenerator, width));
        }
        return new Ladder(lines, ladderHeight);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
