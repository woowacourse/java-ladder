package ladder.domain.ladder;

import ladder.domain.RandomGenerator;
import ladder.domain.laddergame.Position;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final int heightOfLadder, final int widthOfLadder, final RandomGenerator randomBooleanGenerator) {

        this.lines = IntStream.range(0, heightOfLadder)
                .mapToObj(i -> new Line(widthOfLadder, randomBooleanGenerator))
                .collect(Collectors.toList());
    }

    //방법2. 플레이어의 포지션 넣어주면, 반환하는 경우
    public Position findEndPositionOf(Position position) {
        Position endPosition = position;

        for (Line line : lines) {
            endPosition = line.findNextPosition(endPosition);
        }
        return endPosition;
    }


    public List<Line> getLinesOfLadder() {
        return Collections.unmodifiableList(lines);
    }

}
