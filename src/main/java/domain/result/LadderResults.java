package domain.result;

import domain.ladder.Floor;
import domain.ladder.Ladder;
import domain.player.PlayerNames;
import domain.result.message.ResultExceptionMessage;
import java.util.List;

public class LadderResults {
    private final PlayerNames playerNames;
    private final Ladder ladder;
    private final List<LadderResult> results;

    public LadderResults(final PlayerNames playerNames, final Ladder ladder, final List<LadderResult> results) {
        validateTotalResults(playerNames, results);
        this.playerNames = playerNames;
        this.ladder = ladder;
        this.results = List.copyOf(results);
    }

    private void validateTotalResults(final PlayerNames playerNames, final List<LadderResult> results) {
        if (results.size() != playerNames.getCount()) {
            throw new IllegalArgumentException(ResultExceptionMessage.TOTAL_RESULTS_SIZE);
        }
    }

    public String getPlayerNameOfIndex(int index) {
        return playerNames.getNameOfIndex(index);
    }

    public int getPlayerCount() {
        return playerNames.getCount();
    }

    public List<Floor> getFloors() {
        return ladder.getFloors();
    }

    public Ladder getLadder() {
        return ladder;
    }

    public String getLadderResultOfIndex(int index) {
        return results.get(index).getResult();
    }

    public int getLadderResultsSize() {
        return results.size();
    }
}
