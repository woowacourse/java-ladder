package ladder.dto;

import java.util.Map;

/**
 * 이 클래스는 사다리 게임의 결과를 출력하는 과정에서 필요한 정보를 가지고 있는 클래스입니다
 * <p>
 * 사용자의 이름과 결과를 쌍으로 가지고 있습니다
 */
public class PlayerResultDto {

    private final Map<String, String> playerResults;

    public PlayerResultDto(Map<String, String> playerResults) {
        this.playerResults = playerResults;
    }

    public Map<String, String> getPlayerResults() {
        return playerResults;
    }
}
