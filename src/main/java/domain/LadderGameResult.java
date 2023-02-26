package domain;

import exception.PlayerNotInResultException;
import java.util.Collections;
import java.util.Map;

public class LadderGameResult {

    private static final String PLAYER_NOT_IN_RESULT_ERROR_MESSAGE = "참여하지 않은 플레이어 입니다.";

    private final Map<Player, Prize> result;

    public LadderGameResult(Map<Player, Prize> result) {
        this.result = result;
    }

    public Prize getPrizeOfPlayer(Player player) {
        validateResultContainPlayer(player);
        return result.get(player);
    }

    public Map<Player, Prize> getResult() {
        return Collections.unmodifiableMap(result);
    }

    private void validateResultContainPlayer(Player player) {
        if (!result.containsKey(player)) {
            throw new PlayerNotInResultException(PLAYER_NOT_IN_RESULT_ERROR_MESSAGE);
        }
    }
}
