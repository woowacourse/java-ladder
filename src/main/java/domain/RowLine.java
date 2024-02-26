package domain;

import static domain.ConnectionStatus.DISCONNECTED;

import java.util.List;

public class RowLine {

    private final List<ConnectionStatus> connections;

    public RowLine(List<ConnectionStatus> connections) {
        this.connections = connections;
    }

    public ConnectionStatus getRightConnection(int index) {
        if (isRightIndexOutOfRange(index)) {
            return DISCONNECTED;
        }
        return connections.get(index);
    }

    public ConnectionStatus getLeftConnection(int index) {
        if (isLeftIndexOutOfRange(index)) {
            return DISCONNECTED;
        }
        return connections.get(index - 1);
    }

    public int getConnectionCount() {
        return connections.size();
    }

    private boolean isRightIndexOutOfRange(int index) {
        if (index >= getConnectionCount()) {
            return true;
        }
        return false;
    }

    private boolean isLeftIndexOutOfRange(int index) {
        if (index <= 0) {
            return true;
        }
        return false;
    }
}
