package ladder.domain.ladder;

import ladder.domain.rule.BlockGenerator;
import ladder.exception.LadderLengthException;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final BlockGenerator blockGenerator;
    private final List<Line> lines;

    public Ladder(final int playerNumber, final int height, final BlockGenerator blockGenerator) {
        validateLadderLength(playerNumber, height);
        this.blockGenerator = blockGenerator;
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
            lines.add(new Line(playerNumber, blockGenerator));
        }
        return lines;
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
