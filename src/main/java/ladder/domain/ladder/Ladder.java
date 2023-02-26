package ladder.domain.ladder;

import ladder.domain.RandomGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(final int numberOfPlayers, final int heightOfLadder, final RandomGenerator randomGenerator) {
        int widthOfLadder = numberOfPlayers - 1;

        return new Ladder(IntStream.range(0, heightOfLadder)
                .mapToObj(i -> Line.of(widthOfLadder, randomGenerator))
                .collect(Collectors.toList())
        );
    }

    public List<Line> getLinesOfLadder() {
        return Collections.unmodifiableList(lines);
    }

    public int findEndPositionFrom(int startIndex) {
        int currentPosition = startIndex;

        for (Line line : lines) {
            currentPosition += line.findNextMovingOf(currentPosition);
        }
        return currentPosition;
    }

}
