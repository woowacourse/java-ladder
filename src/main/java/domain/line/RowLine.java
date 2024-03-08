package domain.line;

import domain.ConnectionStatus;

import java.util.List;

public class RowLine {

    private static final int RIGHT = 1;
    private static final int LEFT = -1;
    private static final int DOWN = 0;

    private final List<ConnectionStatus> connections;

    public RowLine(List<ConnectionStatus> connections) {
        this.connections = connections;
    }

    public int findConnectedDirection(int position) {
        int direction = DOWN;
        if (position < connections.size()) {
            ConnectionStatus rightConnection = connections.get(position);
            direction = checkRightConnection(rightConnection, direction);
        }
        if (position > 0) {
            ConnectionStatus leftConnection = connections.get(position - 1);
            direction = checkLeftConnection(leftConnection, direction);
        }
        return direction;
    }

    private static int checkRightConnection(ConnectionStatus rightConnection, int direction) {
        if (rightConnection.isConnect()) {
            direction = RIGHT;
        }
        return direction;
    }

    private static int checkLeftConnection(ConnectionStatus leftConnection, int direction) {
        if (leftConnection.isConnect()) {
            direction = LEFT;
        }
        return direction;
    }

    public List<ConnectionStatus> getConnections() {
        return List.copyOf(connections);
    }

    public int size() {
        return connections.size();
    }
}
