package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;
import laddergame.domain.generator.StepPointGenerator;
import laddergame.domain.ladder.line.Direction;
import laddergame.domain.ladder.line.Line;
import laddergame.domain.ladder.line.LineWidth;

public class LadderLines {

    private final List<Line> lines;

    private LadderLines(List<Line> lines) {
        this.lines = lines;
    }

    public static LadderLines of(StepPointGenerator stepPointGenerator, LineWidth width,
                                 LadderHeight height) {
        List<Line> generated = new ArrayList<>();
        for (int i = 0; i < height.get(); i++) {
            generated.add(Line.of(stepPointGenerator, width));
        }
        return new LadderLines(generated);
    }

    public int findDestinationIndex(int startIndex) {
        int index = startIndex;
        for (Line line : lines) {
            Direction nextDirection = line.getDirectionToMove(index);
            index = nextDirection.computeNextIndex(index);
        }
        return index;
    }

    public int height() {
        return lines.size();
    }

    public int width() {
        Line firstLine = lines.get(0);
        return firstLine.size();
    }

    public List<Line> toLines() {
        return new ArrayList<>(lines);
    }
}
