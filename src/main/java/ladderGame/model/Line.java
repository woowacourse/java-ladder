package ladderGame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private final List<ConnectionStatus> connectionStatuses;

    public Line(int number) {
        connectionStatuses = new ArrayList<>();
        for (int i = 0; i < number - 1; i++) {
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
        if (new Random().nextBoolean()) {
            return ConnectionStatus.CONNECTION;
        }
        return ConnectionStatus.DISCONNECTION;
    }

    public List<ConnectionStatus> getConnectionStatuses() {
        return new ArrayList<>(connectionStatuses);
    }

}
