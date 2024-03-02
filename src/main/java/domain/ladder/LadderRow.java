package domain.ladder;

import generator.BooleanGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderRow {
    private final List<Connection> connections;

    private LadderRow(List<Connection> connections) {
        this.connections = connections;
    }

    static LadderRow create(int width, BooleanGenerator booleanGenerator) {
        List<Connection> connections = new ArrayList<>();
        Connection currentConnection = Connection.first(booleanGenerator.generate());
        for (int i = 0; i < width - 1; i++) {
            connections.add(currentConnection);
            currentConnection = currentConnection.next(booleanGenerator.generate());
        }
        connections.add(currentConnection.makeLastConnection());
        return new LadderRow(connections);
    }

    int move(int index) {
        validateIndexRange(index);
        Connection connection = connections.get(index);
        return connection.move(index);
    }

    private void validateIndexRange(int index) {
        if (index < 0 || index >= connections.size()) {
            throw new IllegalArgumentException("index가 범위를 벗어났습니다.");
        }
    }

    public List<Connection> getConnections() {
        return Collections.unmodifiableList(this.connections);
    }
}
