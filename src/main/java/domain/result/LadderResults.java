package domain.result;

import domain.ladder.Floor;
import domain.ladder.Ladder;
import domain.player.Player;
import domain.player.Players;
import domain.result.message.ResultExceptionMessage;
import java.util.List;

public class LadderResults {
    private final List<LadderResult> results;

    private LadderResults(final List<LadderResult> results) {
        this.results = results;
    }

    public static LadderResults createMatchesCountOf(final int count, final List<LadderResult> results) {
        validateTotalResults(count, results);
        return new LadderResults(results);
    }

    private static void validateTotalResults(final int count, final List<LadderResult> results) {
        if (results.size() != count) {
            throw new IllegalArgumentException(ResultExceptionMessage.TOTAL_RESULTS_SIZE);
        }
    }

    public String getLadderResultOfIndex(final int index) {
        return results.get(index).getResult();
    }

    public int getLadderHeight() {
        return results.size();
    }
}
