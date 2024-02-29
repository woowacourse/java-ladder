package laddergame.domain.connectiongenerator;

import laddergame.domain.ladder.Connection;

import java.util.List;

public interface ConnectionGenerator {
    // TODO 파라미터 이름 바꾸기 e.g number나 count
    List<Connection> generate(int number);
}
