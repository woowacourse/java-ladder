package ladder.domain.ladder;

import ladder.domain.ladder.generator.BlockGenerator;
import ladder.domain.ladder.exception.LadderLengthException;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(final BlockGenerator blockGenerator, final int playerNumber, final int height) {
        validateLadderLength(playerNumber, height);
        List<Line> lines = makeLines(blockGenerator, playerNumber, height);
        return new Ladder(lines);
    }

    private static void validateLadderLength(final int playerNumber, final int height) {
        if (height < playerNumber - 1) {
            throw new LadderLengthException();
        }
    }

    private static List<Line> makeLines(final BlockGenerator blockGenerator, final int playerNumber, final int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            Line line = Line.of(blockGenerator, playerNumber);
            lines.add(line);
        }
        return lines;
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
