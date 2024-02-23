package domain.line;

import domain.ConnectionStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static domain.ConnectionStatus.DISCONNECTED;

public class NonContinuousLineGenerator implements RowLineGenerator {

    @Override
    public RowLine generate(int personCount) {
        List<ConnectionStatus> connections = new ArrayList<>();
        ConnectionStatus prev = DISCONNECTED;
        for (int i = 0; i < personCount - 1; i++) {
            ConnectionStatus decideByPrev = decideCurrentStatus(prev);
            connections.add(decideByPrev);
            prev = decideByPrev;
        }
        return new RowLine(connections);
    }

    ConnectionStatus decideCurrentStatus(ConnectionStatus prev) {
        if (prev.isConnect()) {
            return DISCONNECTED;
        }
        return selectRandomElement(ConnectionStatus.getAllStatus());
    }

    private ConnectionStatus selectRandomElement(List<ConnectionStatus> collection) {
        Collections.shuffle(collection);
        return collection.get(0);
    }
}
