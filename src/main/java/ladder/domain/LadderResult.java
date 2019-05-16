package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {
    LadderRewards rewards;

    public LadderResult(String text) {
        rewards = new LadderRewards(text);
    }

    public LadderResult(LadderRewards reward) {
        this.rewards = reward;
    }

    public String run(Ladder ladder, int index) {
        List<LadderRow> rows = ladder.status();
        for (int j = 0; j < rows.size(); j++) {
            List<Integer> currentLines = rows.get(j).status();
            index += currentLines.get(index);
        }

        return rewards.reward(index);
    }

    public PlayerResult run(Ladder ladder, Player player) {
        int index = player.position();
        PlayerResult result = new PlayerResult(player.name(), run(ladder, index));

        return result;
    }

    public List<PlayerResult> run(Ladder ladder, Players players) {
        List<PlayerResult> resultAll = new ArrayList<>();

        for (Player player : players.list()) {
            resultAll.add(run(ladder, player));
        }
        return resultAll;
    }
}
