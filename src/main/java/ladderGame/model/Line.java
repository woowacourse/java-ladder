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

}
