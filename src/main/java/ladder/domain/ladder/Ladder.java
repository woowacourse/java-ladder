package ladder.domain.ladder;

import ladder.domain.rule.StoolGenerator;
import ladder.exception.LadderLengthException;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final StoolGenerator stoolGenerator;
    private final List<Line> lines;

    public Ladder(final int playerNumber, final int height, final StoolGenerator stoolGenerator) {
        validateLadderLength(playerNumber, height);
        this.stoolGenerator = stoolGenerator;
        this.lines = generateEachLines(playerNumber, height);
    }

    private void validateLadderLength(final int playerNumber, final int height) {
        if (height < playerNumber - 1) {
            throw new LadderLengthException();
        }
    }

    private List<Line> generateEachLines(final int playerNumber, final int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(new Line(playerNumber, stoolGenerator));
        }
        return lines;
    }

    public int getFinalDestinationOf(int startingPoint) {
        int currentPoint = startingPoint;
        for (Line line : lines) {
            currentPoint = line.goDownAndGetPosition(currentPoint);
        }
        return currentPoint;
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
