package domain.line;

import domain.ConnectionStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static domain.ConnectionStatus.DISCONNECTED;

public class RandomLinesGenerator implements RowLinesGenerator {

    @Override
    public List<RowLine> generateLines(int personCount, int height) {
        List<RowLine> lines = new ArrayList<>();
        for (int j = 0; j < height; j++) {
            List<ConnectionStatus> connections = new ArrayList<>();
            makeRandomConnections(personCount, DISCONNECTED, connections);
            lines.add(new RowLine(connections));
        }
        return lines;
    }

    private void makeRandomConnections(int personCount, ConnectionStatus prev, List<ConnectionStatus> connections) {
        for (int i = 0; i < personCount - 1; i++) {
            ConnectionStatus decideByPrev = decideCurrentStatus(prev);
            connections.add(decideByPrev);
            prev = decideByPrev;
        }
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
