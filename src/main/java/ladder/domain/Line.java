package ladder.domain;

import static ladder.domain.LineStatus.DISCONNECTED;
import static ladder.domain.LineStatus.from;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ladder.util.BooleanGenerator;

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
        if (position.hasPrevious()) {
            return statuses.get(position.getPrevious());
        }
        return DISCONNECTED;
    }

    private static LineStatus generateLineStatus(
            final BooleanGenerator booleanGenerator,
            final LineStatus previousLineStatus
    ) {
        final boolean status = booleanGenerator.generate();
        if (previousLineStatus.isDisconnected()) {
            return from(status);
        }
        return DISCONNECTED;
    }

    public Position play(final Position position) {
        if (isPreviousConnected(position)) {
            return position.getPrevious();
        }

        if (isNextConnected(position)) {
            return position.getNext();
        }

        return position;
    }

    private boolean isPreviousConnected(final Position position) {
        if (position.hasPrevious()) {
            return statuses.getOrDefault(position.getPrevious(), DISCONNECTED).isConnected();
        }
        return false;
    }

    private boolean isNextConnected(final Position position) {
        if (position.hasNext()) {
            return statuses.getOrDefault(position, DISCONNECTED).isConnected();
        }
        return false;
    }

    public List<LineStatus> getLine() {
        return new ArrayList<>(statuses.values());
    }
}
