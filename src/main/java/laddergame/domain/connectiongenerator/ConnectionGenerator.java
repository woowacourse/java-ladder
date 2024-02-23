package laddergame.domain.connectiongenerator;

import laddergame.domain.Connection;

import java.util.List;

public interface ConnectionGenerator {
    List<Connection> getConnections(int peopleNumber);
}
