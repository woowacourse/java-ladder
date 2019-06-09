package ladderGame.model.ladder;

import java.util.List;

public class LadderResultFactory {
    public static LadderResult generatesResult(Ladder ladder, List<String> players, List<String> results) {
        return new LadderResult(ladder, players, results);
    }
}
