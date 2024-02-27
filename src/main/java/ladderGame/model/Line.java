package ladderGame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Line {
    private final List<ConnectionStatus> connectionStatuses;
    private final BooleanGenerator booleanGenerator;

    public Line(BooleanGenerator booleanGenerator, int number) {
        this.booleanGenerator = booleanGenerator;

        connectionStatuses = new ArrayList<>();
        for(int i = 0; i < number - 1; i++) {
            makeLine(i);
        }
    }

    private void makeLine(int index) {
        if (index == 0 || !connectionStatuses.get(index - 1).equals(ConnectionStatus.CONNECTION)) {
            connectionStatuses.add(decideConnectionStatus());
            return;
        }
        connectionStatuses.add(ConnectionStatus.DISCONNECTION);
    }

    private ConnectionStatus decideConnectionStatus() {
        if (booleanGenerator.generate()) {
            return ConnectionStatus.CONNECTION;
        }
        return ConnectionStatus.DISCONNECTION;
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
