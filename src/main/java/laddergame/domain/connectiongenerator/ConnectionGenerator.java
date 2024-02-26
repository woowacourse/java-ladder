package laddergame.domain.connectiongenerator;

import laddergame.domain.ladder.Connection;

import java.util.List;

public interface ConnectionGenerator {
    List<Connection> generate(int connectionNumber);
}
