package domain;

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
                connectStrategy.generate(), previous -> findNextConnection(previous,
                    connectStrategy))
            .limit(playerCount - 1)
            .toList();
        return new Line(connections);
    }

    public int findNextIndex(int previousIndex) {
        if (previousIndex < 0 || previousIndex > connections.size()) {
            throw new IllegalArgumentException("비정상적인 index입니다.");
        }
        if (previousIndex < connections.size() && connections.get(previousIndex) == Connection.CONNECTED) {
            return previousIndex + 1;
        }
        if (previousIndex > 0 && connections.get(previousIndex - 1) == Connection.CONNECTED) {
            return previousIndex - 1;
        }
        return previousIndex;
    }

    private static Connection findNextConnection(Connection previous, ConnectStrategy connectStrategy) {
        if (previous.equals(Connection.CONNECTED)) {
            return Connection.DISCONNECTED;
        }
        return connectStrategy.generate();
    }

    public List<Connection> getConnections() {
        return connections;
    }
}
