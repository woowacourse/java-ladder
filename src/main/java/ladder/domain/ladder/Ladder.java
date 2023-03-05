package ladder.domain.ladder;

import ladder.domain.RandomGenerator;
import ladder.domain.laddergame.Position;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(final List<Line> lines) {
        validateLines(lines);
        this.lines = lines;
    }

    public static Ladder from(final int heightOfLadder, final int widthOfLadder, final RandomGenerator randomBooleanGenerator) {
        final List<Line> lines = IntStream.range(0, heightOfLadder)
                .mapToObj(i -> Line.from(widthOfLadder, randomBooleanGenerator))
                .collect(Collectors.toList());

        return new Ladder(lines);
    }

    private void validateLines(final List<Line> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("사다리에 줄이 존재하지 않습니다.");
        }
    }

    public Position findEndPositionOf(final Position position) {
        Position endPosition = position;

        for (final Line line : lines) {
            endPosition = line.findNextPosition(endPosition);
        }
        return endPosition;
    }

    public List<List<Boolean>> getLadder() {
        return lines.stream()
                .map(line -> line.getDirections()
                        .stream()
                        .map(Direction::isRightConnected)
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }

}
