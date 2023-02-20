package ladder.domain.ladder;

import ladder.domain.ladder.generator.BlockGenerator;
import ladder.domain.ladder.exception.LadderLengthException;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;
    private final BlockGenerator blockGenerator;

    public Ladder(final BlockGenerator blockGenerator, final int playerNumber, final int height) {
        validateLadderLength(playerNumber, height);
        this.blockGenerator = blockGenerator;
        this.lines = makeLines(playerNumber, height);
    }

    private void validateLadderLength(final int playerNumber, final int height) {
        if (height < playerNumber - 1) {
            throw new LadderLengthException();
        }
    }

    public List<Line> makeLines(final int playerNumber, final int height) {
        List<Line> lines = new ArrayList<>();
        Line line = new Line(playerNumber, blockGenerator);

        for (int i = 0; i < height; i++) {
            lines.add(line);
        }
        return lines;
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
