package domain;

import java.util.ArrayList;
import java.util.List;
import strategy.ConnectionStrategy;

public class Line {

    private final List<Connection> connections = new ArrayList<>();
    private final ConnectionStrategy connectionStrategy;

    public Line(int memberCount, ConnectionStrategy connectionStrategy) {
        this.connectionStrategy = connectionStrategy;
        generate(memberCount);
    }

    private void generate(int memberCount) {
        Connection first = connectionStrategy.generateConnection();
        connections.add(first);

        for (int i = 1; i < memberCount - 1; i++) {
            Connection previous = connections.get(i - 1);
            Connection next = previous.makeNextConnection(connectionStrategy);
            connections.add(next);
        }
    }

    public List<Connection> getConnections() {
        return connections;
    }
}
