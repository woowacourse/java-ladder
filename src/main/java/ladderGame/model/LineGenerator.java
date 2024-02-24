package ladderGame.model;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {
    private final BooleanGenerator booleanGenerator;

    public LineGenerator(BooleanGenerator booleanGenerator) {
        this.booleanGenerator = booleanGenerator;
    }

    public List<ConnectionStatus> makeLine(int number) {
        List<ConnectionStatus> connectionStatuses = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            add(connectionStatuses);
        }
        return new ArrayList<>(connectionStatuses);
    }

    private void add(List<ConnectionStatus> connectionStatuses) {
        int index = connectionStatuses.size();
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
}
