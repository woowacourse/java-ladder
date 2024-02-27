package laddergame.domain;

import laddergame.util.LinesGenerator;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {
    private final List<Lines> lines;

    public Ladder(final LinesGenerator linesGenerator,
                  final int playerCount,
                  final Height height) {
        this.lines = IntStream.range(0, height.getHeight())
                .mapToObj(i -> new Lines(linesGenerator, playerCount - 1))
                .collect(Collectors.toList());
    }

    public Direction move(int startX, int startY) {
        if (startY == lines.size()) {
            return Direction.END;
        }
        Direction nextDirection = lines.get(startY).findDirection(startX);
        return nextDirection;
    }

    public List<Lines> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
