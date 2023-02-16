package ladder.domain;

import ladder.exception.LadderLengthException;

import java.util.ArrayList;
import java.util.List;

public class LadderMaker {

    public Ladder makeLadder(final int playerNumber, final int height) {
        validateLadderLength(playerNumber, height);
        List<Line> lines = generateEachLines(playerNumber, height);
        return new Ladder(lines);
    }

    private void validateLadderLength(final int playerNumber, final int height) {
        if (height < playerNumber - 1) {
            throw new LadderLengthException();
        }
    }

    private List<Line> generateEachLines(final int playerNumber, final int height) {
        List<Line> lines = new ArrayList<>();
        LineMaker lineMaker = new LineMaker(new RandomBlockGenerator());

        for (int i = 0; i < height; i++) {
            lines.add(lineMaker.makeLine(playerNumber));
        }
        return lines;
    }
}
