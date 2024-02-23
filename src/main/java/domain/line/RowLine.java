package domain.line;

import domain.ConnectionStatus;

import java.util.List;

public class RowLine {

    private final List<ConnectionStatus> connections;

    public RowLine(List<ConnectionStatus> connections) {
        this.connections = connections;
    }

    public List<ConnectionStatus> getConnections() {
        return List.copyOf(connections);
    }
}
