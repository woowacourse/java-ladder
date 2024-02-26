package laddergame.domain.ladder;

import laddergame.domain.connectiongenerator.ConnectionGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static laddergame.domain.ladder.Connection.CONNECTED;
import static laddergame.domain.ladder.Connection.NOTCONNECTED;

public class RowLine {
    private final List<Connection> connections;

    public RowLine(int peopleNumber, ConnectionGenerator generator) {
        List<Connection> generatedConnection = generator.generate(peopleNumber - 1);
        validateConnection(generatedConnection);

        this.connections = new ArrayList<>();
        this.connections.addAll(generatedConnection);
    }

    private void validateConnection(List<Connection> connections) {
        Connection beforeConnection = NOTCONNECTED;

        for (Connection currentConnection : connections) {
            validateSuccessive(currentConnection, beforeConnection);
            beforeConnection = currentConnection;
        }
    }

    private void validateSuccessive(Connection currentConnection, Connection beforeConnection) {
        if (beforeConnection == CONNECTED && currentConnection == CONNECTED) {
            throw new IllegalArgumentException("사다리 가로선이 연속되었습니다.");
        }
    }

    public List<Connection> getConnections() {
        return Collections.unmodifiableList(connections);
    }
}
