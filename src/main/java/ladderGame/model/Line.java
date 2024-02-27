package ladderGame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Line {
    private final List<ConnectionStatus> connectionStatuses;

    public Line(ConnectionStatus... connectionStatuses) {
        this(List.of(connectionStatuses));
    }

    public Line(List<ConnectionStatus> connectionStatuses) {
        this.connectionStatuses = connectionStatuses;
    }

    public List<ConnectionStatus> getConnectionStatuses() {
        return new ArrayList<>(connectionStatuses);
    }

    public int descend(int index) {
        ConnectionStatus connectionLeft = decideConnectionLeft(index);
        ConnectionStatus connectionRight = decideConnectionRight(index);

        if(connectionLeft.equals(ConnectionStatus.CONNECTION)) {
            return index - 1;
        }
        if(connectionRight.equals(ConnectionStatus.CONNECTION)) {
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
}
