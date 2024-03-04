package laddergame.domain.connectiongenerator;

import laddergame.domain.ladder.Connection;

import java.util.List;
import java.util.stream.Stream;

public class TrueFalseConnectionGenerator implements ConnectionGenerator {
    @Override
    public List<Connection> generate(int number) {
        return Stream.iterate(Connection.CONNECTED, this::generateContraryConnection)
                .limit(number)
                .toList();
    }

    private Connection generateContraryConnection(Connection connection) {
        if (connection == Connection.CONNECTED) {
            return Connection.NOT_CONNECTED;
        }
        return Connection.CONNECTED;
    }
}
