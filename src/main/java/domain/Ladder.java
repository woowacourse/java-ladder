package domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder createByStrategy(BridgeGenerator bridgeGenerator, int height, int personCount) {
        final List<Line> lines = Stream.generate(() -> Line.createByStrategy(bridgeGenerator, personCount))
                .limit(height)
                .toList();

        return new Ladder(lines);
    }

    public Position climb(final Position position) {
        for (Line line : lines) {
            Direction direction = line.findDirection(position);
            position.move(direction);
        }

        return position;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
