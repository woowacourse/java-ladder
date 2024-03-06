package laddergame.domain.connectiongenerator;

import laddergame.domain.ladder.Connection;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static laddergame.domain.ladder.Connection.CONNECTED;
import static laddergame.domain.ladder.Connection.NOT_CONNECTED;

public class RandomConnectionGenerator implements ConnectionGenerator {
    private static final Random random = new Random();

    @Override
    public List<Connection> generate(int number) {
        Connection beforeConnection = addRandomConnection();

        return Stream.iterate(beforeConnection, this::addConnection)
                .limit(number)
                .toList();
    }

    private Connection addConnection(Connection beforeConnection) {
        if (beforeConnection == CONNECTED) {
            beforeConnection = NOT_CONNECTED;
            return beforeConnection;
        }

        beforeConnection = addRandomConnection();
        return beforeConnection;
    }

    private Connection addRandomConnection() {
        if (random.nextBoolean()) {
            return CONNECTED;
        }
        return NOT_CONNECTED;
    }
}
