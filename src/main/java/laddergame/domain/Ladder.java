package laddergame.domain;

import laddergame.util.LinesGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(final LinesGenerator linesGenerator,
                  final int playerCount,
                  final Height height) {
        this.lines = IntStream.range(0, height.getHeight())
                .mapToObj(i -> linesGenerator.generate(playerCount - 1))
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
