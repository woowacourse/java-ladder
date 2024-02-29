package domain;

import static domain.Connection.*;

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
                previous -> previous.findNextConnection(connectStrategy))
            .limit(playerCount - 1)
            .toList();
        return new Line(connections);
    }

    public int findNextIndex(int previousIndex) {
        if (previousIndex < 0 || previousIndex > connections.size()) {
            throw new IllegalArgumentException("비정상적인 index입니다.");
        }
        if (previousIndex < connections.size() && connections.get(previousIndex) == CONNECTED) {
            return previousIndex + 1;
        }
        if (previousIndex > 0 && connections.get(previousIndex - 1) == CONNECTED) {
            return previousIndex - 1;
        }
        return previousIndex;
    }

    public List<Connection> getConnections() {
        return connections;
    }
}
