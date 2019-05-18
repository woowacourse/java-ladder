package laddergame.domain;

import java.util.Map;

public class LadderGameResult {
    private final Map<Player, Reward> result;

    public LadderGameResult(Map<Player, Reward> result) {
        this.result = result;
    }

    public Reward result(String name) {
        Player player = new Player(name);
        if (!result.keySet().contains(player)) {
            throw new IllegalArgumentException("해당 참가자는 존재하지 않습니다");
        }
        return result.get(player);
    }

    public Map<Player, Reward> allResult() {
        return result;
    }
}
