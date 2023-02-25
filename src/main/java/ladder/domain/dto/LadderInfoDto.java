package ladder.domain.dto;

import java.util.List;

/**
 * 이 클래스는 사다리를 출력하는 과정에서 필요한 정보를 가지고 있는 클래스입니다
 * <p>
 * 사용자의 이름, 사다리 정보, 결과의 이름을 가지고 있습니다
 */
public class LadderInfoDto {

    private final List<String> playerNames;
    private final List<Boolean> isRightConnected;
    private final List<String> resultNames;

    public LadderInfoDto(List<String> playerNames, List<Boolean> isRightConnected, List<String> resultNames) {
        this.playerNames = playerNames;
        this.isRightConnected = isRightConnected;
        this.resultNames = resultNames;
    }

    public List<Boolean> getIsRightConnected() {
        return isRightConnected;
    }

    public List<String> getResultNames() {
        return resultNames;
    }

    public List<String> getPlayerNames() {
        return playerNames;
    }
}
