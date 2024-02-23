package domain;

import java.util.List;

public class RowLine {

    private final List<ConnectionStatus> connections;

    public RowLine(List<ConnectionStatus> connections) {
        this.connections = connections;
    }

    public ConnectionStatus getConnection(int index) {
        return connections.get(index);
    }

    public int getConnectionCount() {
        return connections.size();
    }

    public List<ConnectionStatus> getConnections() {
        return List.copyOf(connections);
    }
}
