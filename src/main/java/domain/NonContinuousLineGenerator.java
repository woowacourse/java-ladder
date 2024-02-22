package domain;

import static domain.ConnectionStatus.DISCONNECTED;

import java.util.ArrayList;
import java.util.List;
import util.RandomElementSelector;

public class NonContinuousLineGenerator implements RowLineGenerator {

    ConnectionStatus decideCurrentStatus(ConnectionStatus prev) {
        if (prev.isConnect()) {
            return DISCONNECTED;
        }
        return RandomElementSelector.selectRandomElement(ConnectionStatus.getAllStatus());
    }

    @Override
    public RowLine generate(Integer personCount) {
        List<ConnectionStatus> connections = new ArrayList<>();
        ConnectionStatus prev = DISCONNECTED;
        for (int i = 0; i < personCount - 1; i++) {
            ConnectionStatus decideByPrev = decideCurrentStatus(prev);
            connections.add(decideByPrev);
            prev = decideByPrev;
        }
        return new RowLine(connections);
    }
}
