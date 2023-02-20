package laddergame.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class TestConnectionMaker implements ConnectionStrategy {

    private final Queue<Connection> connections;

    public TestConnectionMaker(final List<Connection> connections) {
        this.connections = new LinkedList<>(connections);
    }

    public Connection connect() {
        return connections.remove();
    }
}
