package domain.result;

import domain.ladder.Floor;
import domain.ladder.Ladder;
import domain.player.Player;
import domain.player.Players;
import domain.result.message.ResultExceptionMessage;
import java.util.List;

public class LadderResults {
    private final Players players;
    private final Ladder ladder;
    private final List<LadderResult> results;

    public LadderResults(final Players players, final Ladder ladder, final List<LadderResult> results) {
        validateTotalResults(players, results);
        this.players = players;
        this.ladder = ladder;
        this.results = List.copyOf(results);
    }

    private void validateTotalResults(final Players players, final List<LadderResult> results) {
        if (results.size() != players.getPlayerCount()) {
            throw new IllegalArgumentException(ResultExceptionMessage.TOTAL_RESULTS_SIZE);
        }
    }

    public String getPlayerNameOfIndex(final int index) {
        return players.getNameOfIndex(index);
    }

    public int getPlayerCount() {
        return players.getPlayerCount();
    }

    public List<Floor> getFloors() {
        return ladder.getFloors();
    }

    public Ladder getLadder() {
        return ladder;
    }

    public String getLadderResultOfIndex(final int index) {
        return results.get(index).getResult();
    }

    public int getLadderHeight() {
        return results.size();
    }

    public Player getPlayerIndexOf(final int index) {
        return players.getPlayerOfIndex(index);
    }
}
