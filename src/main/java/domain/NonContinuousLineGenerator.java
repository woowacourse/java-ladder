package domain;

import static domain.ConnectionStatus.DISCONNECTED;

import java.util.ArrayList;
import java.util.List;
import util.RandomElementSelector;

public class NonContinuousLineGenerator implements RowLineGenerator {
    @Override
    public RowLine generate(Integer personCount) {
        List<ConnectionStatus> connections = new ArrayList<>();
        ConnectionStatus previousStatus = DISCONNECTED;
        for (int i = 0; i < personCount - 1; i++) {
            ConnectionStatus decidedCurrentStatus = decideCurrentStatus(previousStatus);
            connections.add(decidedCurrentStatus);
            previousStatus = decidedCurrentStatus;
        }
        return new RowLine(connections);
    }

    ConnectionStatus decideCurrentStatus(ConnectionStatus previousStatus) {
        if (previousStatus.isConnect()) {
            return DISCONNECTED;
        }
        return RandomElementSelector.selectRandomConstant(ConnectionStatus.class);
    }
}
