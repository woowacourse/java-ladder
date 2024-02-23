package ladder.domain.connectiongenerator;

import ladder.domain.Connection;

import java.util.List;
import java.util.stream.Stream;

public class AllFalseConnectionGenerator implements ConnectionGenerator {

    @Override
    public List<Connection> getConnections(int peopleNumber) {
        int connectionNumber = peopleNumber - 1;

        return Stream.iterate(Connection.NOTCONNECTED, connection->connection)
                .limit(connectionNumber)
                .toList();
    }
}
