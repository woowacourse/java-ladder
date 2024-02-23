package laddergame.domain.connectiongenerator;

import laddergame.domain.ladder.Connection;

import java.util.List;
import java.util.stream.Stream;

import static laddergame.domain.ladder.Connection.CONNECTED;
import static laddergame.domain.ladder.Connection.NOTCONNECTED;

public class RandomConnectionGenerator implements ConnectionGenerator {
    private static final double PERCENTAGE_OF_CONNECTION = 0.5;

    @Override
    public List<Connection> getConnections(int peopleNumber) {
        int connectionNumber = peopleNumber - 1;
        Connection beforeConnection = NOTCONNECTED;

        return Stream.iterate(beforeConnection, this::addConnection)
                .limit(connectionNumber)
                .toList();
    }

    private Connection addConnection(Connection beforeConnection) {
        if (beforeConnection==CONNECTED) {
            beforeConnection = NOTCONNECTED;
            return beforeConnection;
        }

        beforeConnection = addRandomConnection();
        return beforeConnection;
    }

    private Connection addRandomConnection() {

        if(Math.random() <= PERCENTAGE_OF_CONNECTION){
            return CONNECTED;
        }
        return NOTCONNECTED;
    }
}
