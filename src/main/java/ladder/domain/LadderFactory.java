package ladder.domain;

import java.util.List;

public class LadderFactory {
    public static Ladder getLadder(List<Player> players, int depth) {
        return new Ladder(players, depth);
    }
}
