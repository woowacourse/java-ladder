package ladder.domain;

import java.util.HashMap;
import java.util.Map;

public class LadderResultGenerator {

    private LadderResultGenerator() {
    }

    public static PlayerResults result(Ladder ladder, Players players) {
        Map<Integer, Integer> results = new HashMap<>();
        for (Player player : players.list()) {
            results.put(player.position(), result(ladder, player.position()));
        }
        return new PlayerResults(results);
    }

    private static int result(Ladder ladder, int position) {
        return ladder.rows().stream()
                .reduce(position,
                        (accumulator, ladderRow) -> accumulator + ladderRow.status().get(accumulator).position(),
                        (accumulator, element) -> accumulator + element);
    }
}
