package domain.ladder;

import generator.BooleanGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Floor {
    private final List<Connection> connections;

    private Floor(List<Connection> connections) {
        this.connections = connections;
    }

    static Floor create(int width, BooleanGenerator booleanGenerator) {
        List<Connection> connections = new ArrayList<>();
        Connection currentConnection = Connection.first(booleanGenerator.generate());
        for (int i = 0; i < width - 1; i++) {
            connections.add(currentConnection);
            currentConnection = currentConnection.next(booleanGenerator.generate());
        }
        connections.add(currentConnection.makeLastConnection());
        return new Floor(connections);
    }

    int crossConnection(int index) {
        validateIndexRange(index);
        Connection connection = connections.get(index);
        return connection.moveToNextIndex(index);
    }

    private void validateIndexRange(int index) {
        if (isOutOfRange(index)) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] rejected value: %d - index가 범위를 벗어났습니다.", index));
        }
    }

    private boolean isOutOfRange(int index) {
        return index < 0 || index >= connections.size();
    }

    public List<Connection> getConnections() {
        return Collections.unmodifiableList(this.connections);
    }
}
