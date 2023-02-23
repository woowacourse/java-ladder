package ladder.domain.ladder;

import ladder.domain.ladder.generator.BlockGenerator;
import ladder.domain.ladder.exception.LadderLengthException;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final BlockGenerator blockGenerator, final int playerNumber, final int height) {
        validateLadderLength(playerNumber, height);
        this.lines = makeLines(blockGenerator, playerNumber, height);
    }

    private void validateLadderLength(final int playerNumber, final int height) {
        if (height < playerNumber - 1) {
            throw new LadderLengthException();
        }
    }

    private List<Line> makeLines(final BlockGenerator blockGenerator, final int playerNumber, final int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            Line line = new Line(blockGenerator, playerNumber);
            lines.add(line);
        }
        return lines;
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
