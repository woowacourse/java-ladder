package laddergame.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(final LineBuilder lineBuilder,
                  final Height height) {
        this.lines = IntStream.range(0, height.getHeight())
                .mapToObj(i -> lineBuilder.build())
                .collect(Collectors.toList());
    }

    public Direction move(Position position) {
        if (position.isSamePositionY(lines.size())) {
            return Direction.END;
        }
        Direction nextDirection = lines.get(position.getY()).findDirection(position.getX());
        return nextDirection;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
