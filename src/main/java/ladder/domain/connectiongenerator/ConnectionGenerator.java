package ladder.domain.connectiongenerator;

import ladder.domain.Connection;

import java.util.List;

public interface ConnectionGenerator {
    List<Connection> getConnections(int peopleNumber);
}
