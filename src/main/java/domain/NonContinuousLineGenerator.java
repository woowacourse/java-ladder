package domain;

import static domain.ConnectionStatus.DISCONNECTED;

import java.util.ArrayList;
import java.util.List;
import util.RandomElementSelector;

public class NonContinuousLineGenerator implements RowLineGenerator {
    @Override
    public RowLine generate(Integer personCount) {
        List<ConnectionStatus> connections = new ArrayList<>();
        ConnectionStatus prev = DISCONNECTED;
        for (int i = 0; i < personCount; i++) {
            ConnectionStatus decideByPrev = decideCurrentStatus(prev);
            connections.add(decideCurrentStatus(prev));
            prev = decideByPrev;
        }
        return new RowLine(connections);
    }

    ConnectionStatus decideCurrentStatus(ConnectionStatus prev) {
        if (prev.isConnect()) {
            return DISCONNECTED;
        }
        return RandomElementSelector.selectRandomElement(ConnectionStatus.getAllStatus());
    }
}
