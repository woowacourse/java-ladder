package laddergame.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int MIN_CONNECTIONS = 1;

    private final List<Boolean> connections;

    private Line(final int playerCount, final PickStrategy pickStrategy) {
        int connectionCount = playerCount - 1;
        validateConnectionCount(connectionCount);
        this.connections = createConnections(connectionCount, pickStrategy);
    }

    public static Line from(final int playerCount) {
        return new Line(playerCount, new RandomBooleanPicker());
    }

    public static Line of(final int playerCount, final PickStrategy pickStrategy) {
        return new Line(playerCount, pickStrategy);
    }

    public List<Boolean> getConnections() {
        return new ArrayList<>(connections);
    }

    private List<Boolean> createConnections(int connectionCount, final PickStrategy pickStrategy) {
        List<Boolean> connections = new ArrayList<>();

        for (int i = 0; i < connectionCount; i++) {
            connections.add(createLineConnections(connections, pickStrategy));
        }

        return connections;
    }

    private boolean createLineConnections(final List<Boolean> connections, final PickStrategy pickStrategy) {
        final boolean pick = pickStrategy.pick();

        if (connections.isEmpty()) {
            return pick;
        }

        if (isOverlap(connections, pick)) {
            return false;
        }

        return pick;
    }

    private static boolean isOverlap(final List<Boolean> connections, final boolean pick) {
        int lastIndex = connections.size() - 1;
        return connections.get(lastIndex) && pick;
    }

    private void validateConnectionCount(final int connectionCount) {
        if (connectionCount < MIN_CONNECTIONS) {
            final String connectionCountMessage = String.format("연결상태는 %s보다 작을 수 없습니다.", connectionCount);
            throw new IllegalStateException(connectionCountMessage);
        }
    }
}
