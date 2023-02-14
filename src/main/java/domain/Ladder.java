package domain;

import utils.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;
    private final LadderHeight ladderHeight;

    private Ladder(List<Line> lines, LadderHeight ladderHeight){
        this.lines = lines;
        this.ladderHeight = ladderHeight;
    }

    public static Ladder create(LadderHeight ladderHeight,
                         int numberOfPeople,
                         NumberGenerator numberGenerator) {
        List<Line> lines = new ArrayList<>();
        Ladder ladder = new Ladder(lines, ladderHeight);
        ladder.addUntilLastLine(numberOfPeople, numberGenerator);
        ladder.addLastLine();
        return ladder;
    }

    private void addUntilLastLine(int numberOfPeople, NumberGenerator numberGenerator) {
        for (int i = 0; i < numberOfPeople - 1; i++) {
            lines.add(Line.create(ladderHeight.getLadderHeight(), numberGenerator));
        }
    }

    private void addLastLine() {
        lines.add(Line.create(ladderHeight.getLadderHeight(), () -> 0));
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
