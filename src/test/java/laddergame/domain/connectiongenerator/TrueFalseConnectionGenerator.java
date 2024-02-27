package laddergame.domain.connectiongenerator;

import laddergame.domain.ladder.Connection;

import java.util.List;
import java.util.stream.Stream;

public class TrueFalseConnectionGenerator implements ConnectionGenerator{
    @Override
    public List<Connection> generate(int connectionNumber) {
        return Stream.iterate(Connection.CONNECTED, connection -> generateContraryConnection(connection))
                .limit(connectionNumber)
                .toList();
    }

    private Connection generateContraryConnection(Connection connection){
        if(connection==Connection.CONNECTED){
            return Connection.NOTCONNECTED;
        }
        return Connection.CONNECTED;
    }
}
