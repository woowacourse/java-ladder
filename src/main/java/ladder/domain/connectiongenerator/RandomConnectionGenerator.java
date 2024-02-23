package ladder.domain.connectiongenerator;

import java.util.List;
import java.util.stream.Stream;

public class RandomConnectionGenerator implements ConnectionGenerator {
    private static final double PERCENTAGE_OF_CONNECTION = 0.5;

    @Override
    public List<Boolean> getConnection(int peopleNumber) {
        int connectionNumber = peopleNumber - 1;
        boolean beforeConnection = false;

        return Stream.iterate(beforeConnection, this::addConnection)
                .limit(connectionNumber)
                .toList();
    }

    private boolean addConnection(boolean beforeConnection) {
        if (beforeConnection) {
            beforeConnection = false;
            return beforeConnection;
        }

        beforeConnection = addRandomConnection();
        return beforeConnection;
    }

    private boolean addRandomConnection() {
        return Math.random() >= PERCENTAGE_OF_CONNECTION;
    }
}
