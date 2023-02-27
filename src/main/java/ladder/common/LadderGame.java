package ladder.common;

import java.util.List;
import java.util.Map;

/**
 * 이 인터페이스는 사다리 게임에 대한 기본적인 로직을 담고 있습니다
 * <p>
 * Dto 를 통해서 소통하는 것 대신, 바로 Collection 들을 활용해서 소통합니다
 */
public interface LadderGame {

    void initializePlayers(List<String> playerNames);

    void initializeResults(List<String> resultNames);

    void initializeLadder(int height);

    List<String> getPlayerNames();

    List<List<Boolean>> getLadderRows();

    List<String> getResultNames();

    Map<String, String> calculateResult();
}
