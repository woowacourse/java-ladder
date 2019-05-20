package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderResultGenerator {

    private LadderResultGenerator() {
    }

    public static LadderResults result(Ladder ladder, Players players, LadderRewards ladderRewards) {
        Map<String, String> results = new HashMap<>();
        for (Player player : players.list()) {
            results.put(player.name(), ladderRewards.reward(find(ladder, player.position())));
        }
        return new LadderResults(results);
    }

    public static int find(Ladder ladder, int position) {
        return ladder.rows().stream()
                .reduce(position,
                        (accumulator, ladderRow) -> accumulator + ladderRow.status().get(accumulator).position(),
                        (accumulator, element) -> accumulator + element);
    }
}
