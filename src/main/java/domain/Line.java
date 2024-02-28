package domain;

import java.util.ArrayList;
import java.util.List;
import strategy.ConnectionStrategy;

public class Line {

    private final List<Connection> connections;

    private Line(List<Connection> connections) {
        this.connections = connections;
    }

    public static Line of(int memberCount, ConnectionStrategy connectionStrategy) {
        List<Connection> connections = new ArrayList<>();
        connections.add(connectionStrategy.generateConnection());

        for (int i = 1; i < memberCount - 1; i++) {
            Connection previous = connections.get(i - 1);
            Connection next = previous.makeNextConnection(connectionStrategy);
            connections.add(next);
        }
        return new Line(connections);
    }

    public List<Connection> getConnections() {
        return connections;
    }
}
