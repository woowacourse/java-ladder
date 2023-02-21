package laddergame.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TestConnectionMaker implements ConnectionStrategy {

    private final Queue<Connection> connections;

    public TestConnectionMaker(final List<Connection> connections) {
        this.connections = new LinkedList<>(connections);
    }

    public Connection connect() {
        return connections.remove();
    }
}
