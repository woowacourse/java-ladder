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
        Ladder ladder = new Ladder(lines, ladderHeight);
        ladder.addLines(numberOfPeople - NUMBER_OF_PEOPLE_TO_WIDTH_SCALE, numberGenerator);
        return ladder;
    }

    private void addLines(int width, NumberGenerator numberGenerator) {
        for (int i = 0; i < getLadderHeight(); i++) {
            lines.add(Line.create(width, numberGenerator));
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getLadderHeight() {
        return ladderHeight.getLadderHeight();
    }
}
