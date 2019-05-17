package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LadderResult {
    private LadderRewards rewards;

    public LadderResult(LadderRewards reward) {
        this.rewards = reward;
    }

    public String result(Ladder ladder, int position) {
//        Stack<Integer> t = new Stack<>();
//        t.push(position);
//        ladder.status().forEach(row -> {
//            int index = t.pop();
//            t.push(index + row.status().get(index));
//        });

        int index = ladder.status().stream()
                .reduce(position,
                        (accumulator, ladderRow) -> accumulator + ladderRow.status().get(accumulator),
                        (accumulator, element) -> accumulator + element);

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
