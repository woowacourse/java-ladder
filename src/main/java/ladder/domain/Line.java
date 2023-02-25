package ladder.domain;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Line {

    private final Map<Position, LineStatus> statuses;

    private Line(final Map<Position, LineStatus> statuses) {
        this.statuses = statuses;
    }

    public static Line generate(final BooleanGenerator booleanGenerator, final int width) {
        final Map<Position, LineStatus> statuses = new LinkedHashMap<>();
        for (Position position : Position.range(width)) {
            final LineStatus previousStatus = getPreviousLineStatus(statuses, position);
            statuses.put(position, generateLineStatus(booleanGenerator, previousStatus));
        }
        return new Line(statuses);
    }

    private static LineStatus getPreviousLineStatus(final Map<Position, LineStatus> statuses, final Position position) {
        return statuses.getOrDefault(position.getPrevious(), LineStatus.DISCONNECTED);
    }

    private static LineStatus generateLineStatus(
            final BooleanGenerator booleanGenerator,
            final LineStatus previousLineStatus
    ) {
        final boolean status = booleanGenerator.generate();
        if (previousLineStatus.isDisconnected()) {
            return LineStatus.from(status);
        }
        return LineStatus.DISCONNECTED;
    }

    public Position play(final Position position) {
        if (isConnected(position.getPrevious())) {
            return position.getPrevious();
        }

        if (isConnected(position)) {
            return position.getNext();
        }

        return position;
    }

    private boolean isConnected(final Position position) {
        return statuses.getOrDefault(position, LineStatus.DISCONNECTED).isConnected();
    }

    public List<LineStatus> getLine() {
        return new ArrayList<>(statuses.values());
    }
}
