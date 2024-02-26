package laddergame.domain.connectiongenerator;

import laddergame.domain.ladder.Connection;

import java.util.List;

public interface ConnectionGenerator {
    //TODO generate로 메서드 이름 수정
    //TODO 매개변수 peopleNumber를 받기보다 number만쓰고 -1을 한 값을 받도록 수정
    List<Connection> getConnections(int peopleNumber);
}
