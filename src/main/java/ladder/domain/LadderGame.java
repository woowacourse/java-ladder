package ladder.domain;

import java.util.List;
import ladder.dto.LadderInfoDto;
import ladder.dto.PlayerResultDto;

/**
 * 이 클래스는 사다리 게임을 테스트하는 과정에서 구현체를 바꾸기 위해서 존재합니다
 * <p>
 * 이 클래스와, dto 만을 공통적으로 알고 있고, 그 외의 의존성은 서로에게 존재하지 않습니다
 */
public interface LadderGame {

    void initializePlayers(List<String> playerNames);

    void initializeResults(List<String> resultNames);

    void initializeLadder(int height);

    LadderInfoDto getLadderInfo();

    PlayerResultDto calculateResult();
}
