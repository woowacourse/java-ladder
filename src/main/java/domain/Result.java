package domain;

import java.util.Collections;
import java.util.Map;

public class Result {

    private final Map<Player, Prize> result;

    Result(Map<Player, Prize> result) {
        this.result = result;
    }

    public Prize match(String playerName) {
        Player targetPlayer = new Player(playerName);

        if (result.containsKey(targetPlayer)) {
            return result.get(targetPlayer);
        }

        throw new IllegalArgumentException(String.format("존재하지 않는 플레이어입니다. 입력값: %s", playerName));
    }

    public Map<Player, Prize> matchAll() {
        return Collections.unmodifiableMap(result);
    }
}
