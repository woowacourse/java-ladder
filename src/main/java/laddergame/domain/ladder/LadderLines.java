package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import laddergame.domain.generator.StepPointGenerator;
import laddergame.domain.ladder.line.Line;
import laddergame.domain.ladder.line.LineWidth;

public class LadderLines {

    private final List<Line> lines;

    private LadderLines(final List<Line> lines) {
        this.lines = lines;
    }

    public static LadderLines of(final StepPointGenerator stepPointGenerator, final LineWidth width,
                                 final LadderHeight height) {
        final List<Line> generated = new ArrayList<>();
        for (int i = 0; i < height.get(); i++) {
            generated.add(Line.of(stepPointGenerator, width));
        }
        return new LadderLines(generated);
    }

    public int findDestinationIndex(final int startIndex) {
        int index = startIndex;
        for (Line line : lines) {
            index = line.findNextLineIndex(index);
        }
        return index;
    }

    public int height() {
        return lines.size();
    }

    public List<Line> toLines() {
        return new ArrayList<>(lines);
    }
}
