package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> ladder;

    public Ladder(final int numberOfPlayers, final int heightOfLadder, final RandomGenerator randomGenerator) {
        this.ladder = createLadder(numberOfPlayers, heightOfLadder, randomGenerator);
    }

    private List<Line> createLadder(final int numberOfPlayers, final int heightOfLadder, final RandomGenerator randomGenerator) {
        int widthOfLadder = numberOfPlayers - 1;

        List<Line> lines = new ArrayList<>();

        for (int idx = 0; idx < heightOfLadder; idx++) {
            lines.add(new Line(widthOfLadder, randomGenerator));
        }

        return lines;
    }

    public List<Line> getLinesOfLadder() {
        return Collections.unmodifiableList(ladder);
    }


}
