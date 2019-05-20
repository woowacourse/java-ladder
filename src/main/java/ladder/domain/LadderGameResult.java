package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderGameResult {
    private Map<Player, Prize> nameToPrize;

    public LadderGameResult(int[] result, Players players, Prizes prizes) {
        this.nameToPrize = bindNameToPrize(result, players, prizes);
    }

    private Map<Player, Prize> bindNameToPrize(int[] result, Players players, Prizes prizes) {
        Map<Player, Prize> nameToPrize = new HashMap<>();
        for (int i = 0; i < result.length; i++) {
            nameToPrize.put(players.getPlayer(result[i]), prizes.getPrize(i));
        }
        return nameToPrize;
    }

    public Map<Player, Prize> getNameToPrize() {
        return this.nameToPrize;
    }
}
