package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {
    LadderReward rewards;

    public LadderResult(String text) {
        rewards = new LadderReward(text);
    }

    public LadderResult(LadderReward reward) {
        this.rewards = reward;
    }

    public LadderReward reward() {
        return rewards;
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

    public List<String> run(Ladder ladder) {
        List<String> resultAll = new ArrayList<>();
        for (int i = 0; i < rewards.size(); i++) {
            resultAll.add(run(ladder, i));
        }
        return resultAll;
    }
}
