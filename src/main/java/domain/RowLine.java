package domain;

import java.util.List;

public class RowLine {

    private final List<ConnectionStatus> connections;

    public RowLine(List<ConnectionStatus> connections) {
        this.connections = connections;
    }

    public boolean hasRightConnection(int index) {
        return connections.get(index).isConnect();
    }

    public List<ConnectionStatus> getConnections() {
        return List.copyOf(connections);
    }
}
