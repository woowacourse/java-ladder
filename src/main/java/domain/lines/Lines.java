package domain.lines;

import domain.BooleanGenerator;
import domain.Player;
import domain.line.Line;
import domain.line.Point;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Lines {
    private List<Line> lines;
    private final int height;
    private final CountToPoints countToPoints;

    public Lines(final int height, final int personCount, BooleanGenerator booleanGenerator) {
        this.height = height;
        this.countToPoints = new CountToPoints(personCount, booleanGenerator);
        this.lines = new ArrayList<>();
    }

    public List<Line> getLines() {
        if (lines.isEmpty()) {
            createLines();
        }
        return Collections.unmodifiableList(lines);
    }

    private void createLines() {
        this.lines = IntStream.range(0, height)
                .mapToObj(index -> new Line(createPoints()))
                .toList();
    }

    public void climb(Player player) {
        getLines().forEach(line -> {
            int currPosition = player.getPosition();
            player.move(line.nextPosition(currPosition));
        });
    }

    private List<Point> createPoints() {
        return countToPoints.value();
    }
}
