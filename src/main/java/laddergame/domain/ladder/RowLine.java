package laddergame.domain.ladder;

import laddergame.domain.connectiongenerator.ConnectionGenerator;
import laddergame.domain.gameelements.Players;
import laddergame.domain.gameelements.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static laddergame.domain.ladder.Connection.CONNECTED;
import static laddergame.domain.ladder.Connection.NOT_CONNECTED;

public class RowLine {
    private final List<Connection> connections;

    public RowLine(int peopleNumber, ConnectionGenerator generator) {
        List<Connection> generatedConnection = generator.generate(peopleNumber - 1);
        validateConnection(generatedConnection);

        this.connections = new ArrayList<>();
        this.connections.addAll(generatedConnection);
    }

    public void move(Players players) {
        players.getPlayers()
                .forEach(p -> moveByConnection(p.getPlayerPosition()));
    }

    private void moveByConnection(Position playerPosition) {
        if (canMoveLeftPosition(playerPosition.leftPosition())) {
            playerPosition.moveLeft();
            return;
        }

        if (canMoveRightPosition(playerPosition.rightPosition())) {
            playerPosition.moveRight();
        }
    }

    private boolean canMoveLeftPosition(int leftPosition) {
        return leftPosition >= 0
                && connections.get(leftPosition).isConnected();
    }

    private boolean canMoveRightPosition(int rightPosition) {
        return rightPosition < connections.size()
                && connections.get(rightPosition).isConnected();
    }

    private void validateConnection(List<Connection> connections) {
        Connection beforeConnection = NOT_CONNECTED;

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
