package laddergame.domain.connectiongenerator;

import laddergame.domain.ladder.Connection;

import java.util.List;
import java.util.stream.Stream;

public class AllFalseConnectionGenerator implements ConnectionGenerator {

    @Override
    public List<Connection> generate(int number) {
        return Stream.iterate(Connection.NOT_CONNECTED, connection -> connection)
                .limit(number)
                .toList();
    }
}
