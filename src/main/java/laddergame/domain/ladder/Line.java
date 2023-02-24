package laddergame.domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final int MIN_CONNECTIONS = 1;

    private final List<Connection> connections;

    private Line(final int playerCount, final ConnectionStrategy connectionStrategy) {
        int connectionCount = playerCount - 1;
        validateConnectionCount(connectionCount);
        this.connections = createConnections(connectionCount, connectionStrategy);
    }

    private void validateConnectionCount(final int connectionCount) {
        if (connectionCount < MIN_CONNECTIONS) {
            final String connectionCountMessage = String.format("연결상태는 %s보다 작을 수 없습니다.", connectionCount);
            throw new IllegalStateException(connectionCountMessage);
        }
    }

    public static Line of(final int playerCount, final ConnectionStrategy connectionStrategy) {
        return new Line(playerCount, connectionStrategy);
    }

    private List<Connection> createConnections(int connectionCount, final ConnectionStrategy connectionStrategy) {
        List<Connection> connections = new ArrayList<>();

        for (int i = 0; i < connectionCount; i++) {
            final Connection createdConnection = createLineConnections(connections, connectionStrategy);
            connections.add(createdConnection);
        }

        return connections;
    }

    private Connection createLineConnections(final List<Connection> connections, final ConnectionStrategy connectionStrategy) {
        final Connection pick = connectionStrategy.connect();

        if (connections.isEmpty()) {
            return pick;
        }

        if (isOverlap(connections, pick)) {
            return Connection.UNCONNECTED;
        }

        return pick;
    }

    private static boolean isOverlap(final List<Connection> connections, final Connection pick) {
        int lastIndex = connections.size() - 1;
        final Connection lastConnection = connections.get(lastIndex);

        return lastConnection.isOverlap(pick);
    }

    public boolean canMoveLeft(final int playerPosition) {
        final int leftIndex = playerPosition - 1;
        final Connection leftConnection = connections.get(leftIndex);

        return leftConnection.isConnected();
    }

    public boolean canMoveRight(final int playerPosition) {
        if (playerPosition == connections.size()) {
            return false;
        }

        final Connection rightConnection = connections.get(playerPosition);

        return rightConnection.isConnected();
    }

    public List<Connection> getConnections() {
        return new ArrayList<>(connections);
    }
}
