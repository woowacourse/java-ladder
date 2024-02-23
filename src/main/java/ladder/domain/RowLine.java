package ladder.domain;

import ladder.domain.connectiongenerator.ConnectionGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ladder.domain.Connection.CONNECTED;
import static ladder.domain.Connection.NOTCONNECTED;

public class RowLine {
    private static final int MIN_PEOPLE_NUMBER = 1;
    private static final int MAX_PEOPLE_NUMBER = 100;
    private final List<Connection> connections = new ArrayList<>();

    public RowLine(int peopleNumber, ConnectionGenerator generator) {
        validatePeopleNumber(peopleNumber);
        List<Connection> generatedConnection = generator.getConnections(peopleNumber);
        validateConnection(generatedConnection);
        this.connections.addAll(generatedConnection);
    }

    private void validatePeopleNumber(int peopleNumber) {
        if (peopleNumber < MIN_PEOPLE_NUMBER || peopleNumber > MAX_PEOPLE_NUMBER) {
            throw new IllegalArgumentException("참여자 수는 1이상 100이하의 사람 수 입니다.");
        }
    }

    //TODO 가독성 강화하기 - 네이밍
    private void validateConnection(List<Connection> connections) {
        Connection beforeConnection = NOTCONNECTED;

        for (Connection currentConnection : connections) {
            if (beforeConnection==CONNECTED && currentConnection==CONNECTED) {
                throw new IllegalArgumentException("사다리 가로선이 연속되었습니다.");
            }
            beforeConnection = currentConnection;
        }
    }

    public List<Connection> getConnections() {
        return Collections.unmodifiableList(connections);
    }


}
