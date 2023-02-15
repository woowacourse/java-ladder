package ladder.domain;

import static java.util.stream.Collectors.toList;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.stream.Stream;

class Ladder {

    private final List<Line> lines;

    public Ladder(final BooleanGenerator booleanGenerator, final int height, final int width) {
        this.lines = Stream.generate(() -> generateLine(booleanGenerator, width))
                .limit(height)
                .collect(toList());
    }

    private Line generateLine(final BooleanGenerator booleanGenerator, final int width) {
        final Deque<LineStatus> statuses = new ArrayDeque<>();
        for (int i = 0; i < width; i++) {
            statuses.add(generate(booleanGenerator, statuses));
        }
        return new Line(new ArrayList<>(statuses));
    }

    private LineStatus generate(final BooleanGenerator booleanGenerator, final Deque<LineStatus> statuses) {
        if (statuses.isEmpty() || statuses.getLast() == LineStatus.STOP) {
            return LineStatus.from(booleanGenerator.generate());
        }
        return LineStatus.STOP;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
