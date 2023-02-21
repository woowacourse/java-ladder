package ladder.domain;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class Line {
    
    private final List<LineStatus> statuses;

    public Line(final BooleanGenerator booleanGenerator, final int width) {
        this.statuses = generateLine(booleanGenerator, width);
    }

    private List<LineStatus> generateLine(final BooleanGenerator booleanGenerator, final int width) {
        final Deque<LineStatus> statuses = new ArrayDeque<>();
        for (int i = 0; i < width; i++) {
            statuses.add(generateLineStatus(booleanGenerator, statuses));
        }
        return new ArrayList<>(statuses);
    }

    private LineStatus generateLineStatus(final BooleanGenerator booleanGenerator, final Deque<LineStatus> statuses) {
        final boolean status = booleanGenerator.generate();
        if (statuses.isEmpty() || statuses.getLast().isDisconnected()) {
            return LineStatus.from(status);
        }
        return LineStatus.DISCONNECTED;
    }

    public List<LineStatus> getLine() {
        return Collections.unmodifiableList(statuses);
    }
}
