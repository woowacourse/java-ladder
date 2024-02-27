package domain.result;

import domain.player.PlayerNames;
import domain.result.message.ResultExceptionMessage;
import java.util.List;

public class TotalResults {
    private final List<LadderResult> results;
    private final PlayerNames playerNames;


    public TotalResults(final List<LadderResult> results, final PlayerNames playerNames) {
        validateTotalResults(results, playerNames);
        this.results = results;
        this.playerNames = playerNames;
    }

    private void validateTotalResults(final List<LadderResult> results, final PlayerNames playerNames) {
        if (results.size() != playerNames.getCount()) {
            throw new IllegalArgumentException(ResultExceptionMessage.TOTAL_RESULTS_SIZE);
        }
    }
}
