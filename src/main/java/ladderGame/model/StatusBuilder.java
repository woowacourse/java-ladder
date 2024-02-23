package ladderGame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StatusBuilder {
    private List<ConnectionStatus> connectionStatuses;

    public StatusBuilder() {
        connectionStatuses = new ArrayList<>();
    }

    public void add() {
        int index = connectionStatuses.size();
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

    public List<ConnectionStatus> build() {
        return new ArrayList<>(connectionStatuses);
    }
}
