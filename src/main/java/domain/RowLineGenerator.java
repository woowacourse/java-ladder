package domain;

import static domain.ConnectionStatus.DISCONNECTED;

import java.util.ArrayList;
import java.util.List;

public class RowLineGenerator {

    private final ConnectionGenerator connectionGenerator;

    public RowLineGenerator(ConnectionGenerator connectionGenerator) {
        this.connectionGenerator = connectionGenerator;
    }

    public RowLine generate(int personCount) {
        List<ConnectionStatus> connections = new ArrayList<>();
        ConnectionStatus previousStatus = DISCONNECTED;
        for (int i = 0; i < personCount - 1; i++) {
            ConnectionStatus decidedCurrentStatus = connectionGenerator.generateByPreviousStatus(previousStatus);
            connections.add(decidedCurrentStatus);
            previousStatus = decidedCurrentStatus;
        }
        return new RowLine(connections);
    }
}
