package domain;

import static domain.Connection.CONNECTED;

import java.util.List;
import java.util.stream.Stream;
import strategy.ConnectStrategy;

public class Line {

    private final List<Connection> connections;

    private Line(List<Connection> connections) {
        this.connections = connections;
    }

    public static Line of(ConnectStrategy connectStrategy, int playerCount) {
        List<Connection> connections = Stream.iterate(
                connectStrategy.generate(),
                previousConnection -> previousConnection.findNextConnection(connectStrategy))
            .limit(playerCount - 1)
            .toList();
        return new Line(connections);
    }

    public int findNextIndex(int previousIndex) {
        if (previousIndex < 0 || previousIndex > connections.size()) {
            throw new IllegalStateException("비정상적인 index입니다.");
        }
        if (isLeftConnected(previousIndex)) {
            return previousIndex - 1;
        }
        if (isRightConnected(previousIndex)) {
            return previousIndex + 1;
        }
        return previousIndex;
    }

    private boolean isLeftConnected(int previousIndex) {
        return previousIndex > 0 && connections.get(previousIndex - 1) == CONNECTED;
    }

    private boolean isRightConnected(int previousIndex) {
        return previousIndex < connections.size() && connections.get(previousIndex) == CONNECTED;
    }

    public List<Connection> getConnections() {
        return connections;
    }
}
