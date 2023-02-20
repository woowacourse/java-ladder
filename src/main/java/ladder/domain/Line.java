package ladder.domain;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Line {

    private final List<LineStatus> statuses;

    private Line(final List<LineStatus> statuses) {
        this.statuses = statuses;
    }

    public static Line generate(final BooleanGenerator booleanGenerator, final int width) {
        final Deque<LineStatus> statuses = new ArrayDeque<>();
        while (statuses.size() < width) {
            statuses.add(generateLineStatus(booleanGenerator, statuses));
        }
        return new Line(new ArrayList<>(statuses));
    }

    private static LineStatus generateLineStatus(
            final BooleanGenerator booleanGenerator,
            final Deque<LineStatus> statuses
    ) {
        final boolean status = booleanGenerator.generate();
        if (isConnectable(statuses)) {
            return LineStatus.from(status);
        }
        return LineStatus.DISCONNECTED;
    }

    private static boolean isConnectable(final Deque<LineStatus> statuses) {
        return statuses.isEmpty() || statuses.getLast().isDisconnected();
    }

    public List<LineStatus> getLine() {
        return Collections.unmodifiableList(statuses);
    }
}
