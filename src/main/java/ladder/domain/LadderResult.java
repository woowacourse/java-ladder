package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {
    private LadderRewards rewards;

    public LadderResult(LadderRewards reward) {
        this.rewards = reward;
    }

    public String result(Ladder ladder, int index) {
        List<LadderRow> rows = ladder.status();
        for (int j = 0; j < rows.size(); j++) {
            List<Integer> currentLines = rows.get(j).status();
            index += currentLines.get(index);
        }

        return rewards.reward(index);
    }

    public PlayerResult result(Ladder ladder, Player player) {
        int index = player.position();

        return new PlayerResult(player.name(), result(ladder, index));
    }

    public List<PlayerResult> result(Ladder ladder, Players players) {
        List<PlayerResult> resultAll = new ArrayList<>();

        for (Player player : players.list()) {
            resultAll.add(result(ladder, player));
        }
        return resultAll;
    }
}
