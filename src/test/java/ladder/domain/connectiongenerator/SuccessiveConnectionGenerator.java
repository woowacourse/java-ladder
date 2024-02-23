package ladder.domain.connectiongenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class SuccessiveConnectionGenerator implements ConnectionGenerator {
    @Override
    public List<Boolean> getConnection(int peopleNumber) {
        int connectionNumber = peopleNumber - 1;

        return Stream.iterate(true, connection->connection)
                .limit(connectionNumber)
                .toList();
    }
}
