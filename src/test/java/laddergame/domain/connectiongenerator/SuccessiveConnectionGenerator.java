package laddergame.domain.connectiongenerator;

import laddergame.domain.ladder.Connection;

import java.util.List;
import java.util.stream.Stream;

public class SuccessiveConnectionGenerator implements ConnectionGenerator {
    @Override
    public List<Connection> generate(int connectionNumber) {
        return Stream.iterate(Connection.CONNECTED, connection -> connection)
                .limit(connectionNumber)
                .toList();
    }
}
