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

    @Override
    public String toString() {
        StringBuilder resultView = new StringBuilder();
        for (Player player : result.keySet()) {
            resultView.append(player.getName())
                    .append(" : ")
                    .append(result.get(player).getName())
                    .append('\n');
        }
        return resultView.toString();
    }
}
