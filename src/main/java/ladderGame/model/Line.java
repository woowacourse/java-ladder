package ladderGame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private final List<ConnectionStatus> connectionStatuses;

    public Line(List<ConnectionStatus> connections) {
        List<ConnectionStatus> statuses = new ArrayList<>();

        statuses.add(connections.get(0));
        for (int i = 1; i < connections.size(); i++) {
            statuses.add(decideConnectionStatus(statuses.get(i - 1), connections.get(i)));
        }
        this.connectionStatuses = statuses;
    }

    private ConnectionStatus decideConnectionStatus(ConnectionStatus previous, ConnectionStatus current) {
        if(previous == ConnectionStatus.DISCONNECTION) {
            return current;
        }
        return ConnectionStatus.DISCONNECTION;
    }

    public int descend(int index) {
        ConnectionStatus connectionLeft = decideConnectionLeft(index);
        ConnectionStatus connectionRight = decideConnectionRight(index);

        if(connectionLeft == ConnectionStatus.CONNECTION) {
            return index - 1;
        }
        if(connectionRight == ConnectionStatus.CONNECTION) {
            return index + 1;
        }
        return index;
    }

    private ConnectionStatus decideConnectionLeft(int index) {
        ConnectionStatus connectionLeft = ConnectionStatus.DISCONNECTION;
        if(index != 0) {
            connectionLeft = connectionStatuses.get(index - 1);
        }

        return connectionLeft;
    }

    private ConnectionStatus decideConnectionRight(int index) {
        ConnectionStatus connectionRight = ConnectionStatus.DISCONNECTION;
        if(index < connectionStatuses.size()) {
            connectionRight = connectionStatuses.get(index);
        }

        return connectionRight;
    }

    public List<ConnectionStatus> getConnectionStatuses() {
        return new ArrayList<>(connectionStatuses);
    }
}
