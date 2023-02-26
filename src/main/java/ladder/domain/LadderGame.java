package ladder.domain;

import ladder.domain.ladder.Block;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.player.PlayerName;
import ladder.domain.player.Players;
import ladder.domain.prize.Result;
import ladder.domain.prize.Results;
import ladder.domain.player.exception.NoSuchPlayerException;

import java.util.*;

public class LadderGame {

    private final Map<PlayerName, Result> results;

    public LadderGame(final Players players, final Results results, final Ladder ladder) {
        this.results = makeResult(players, results, ladder);
    }

    private Map<PlayerName, Result> makeResult(final Players players, final Results results, final Ladder ladder) {
        List<PlayerName> playerNames = new ArrayList<>(players.getPlayers());
        ladder.getLines().forEach(line -> moveOneLine(playerNames, line));
        Map<PlayerName, Result> unSortedResults = connectPlayerAndPrize(playerNames, results.getPrizes());
        return sort(unSortedResults, players.getPlayers());
    }

    private void moveOneLine(List<PlayerName> playerNames, final Line line) {
        for (int i = 0; i < line.getBlocks().size(); i++) {
            Block block = line.getBlocks().get(i);
            moveEachPlayer(playerNames, i, block);
        }
    }

    private void moveEachPlayer(List<PlayerName> playerNames, final int blockIndex, final Block block) {
        if (block.isExistBlock()) {
            int leftPlayerIndex = blockIndex;
            int rightPlayerIndex = blockIndex + 1;
            Collections.swap(playerNames, leftPlayerIndex, rightPlayerIndex);
        }
    }

    private Map<PlayerName, Result> connectPlayerAndPrize(List<PlayerName> playerNames, final List<Result> results) {
        Map<PlayerName, Result> connection = new HashMap<>();
        for (int i = 0; i < playerNames.size(); i++) {
            connection.put(playerNames.get(i), results.get(i));
        }
        return connection;
    }

    private Map<PlayerName, Result> sort(
            final Map<PlayerName, Result> unSortedResults, final List<PlayerName> playerNames) {
        Map<PlayerName, Result> sortedResults = new LinkedHashMap<>();
        for (PlayerName playerName : playerNames) {
            Result result = unSortedResults.get(playerName);
            sortedResults.put(playerName, result);
        }
        return sortedResults;
    }

    public Map<PlayerName, Result> getAllResult() {
        return results;
    }

    public Result getSinglePlayerResult(final PlayerName playerName) {
        Result result = results.get(playerName);
        validatePlayerName(result);
        return result;
    }

    private void validatePlayerName(final Result result) {
        if (result == null) {
            throw new NoSuchPlayerException();
        }
    }
}
