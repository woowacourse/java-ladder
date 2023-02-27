package ladder.domain;

import ladder.domain.ladder.Block;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.player.exception.NoSuchPlayerException;
import ladder.domain.result.Result;
import ladder.domain.result.Results;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final Map<Player, Result> results;

    public LadderGame(final Players players, final Results results, final Ladder ladder) {
        this.results = makeResult(players, results, ladder);
    }

    private Map<Player, Result> makeResult(final Players players, final Results results, final Ladder ladder) {
        List<Player> players1 = new ArrayList<>(players.getPlayers());
        ladder.getLines().forEach(line -> moveOneLine(players1, line));
        Map<Player, Result> unSortedResults = connectPlayerAndPrize(players1, results.getPrizes());
        return sort(unSortedResults, players.getPlayers());
    }

    private void moveOneLine(List<Player> players, final Line line) {
        for (int i = 0; i < line.getBlocks().size(); i++) {
            Block block = line.getBlocks().get(i);
            moveEachPlayer(players, i, block);
        }
    }

    private void moveEachPlayer(List<Player> players, final int blockIndex, final Block block) {
        if (block.isExistBlock()) {
            int leftPlayerIndex = blockIndex;
            int rightPlayerIndex = blockIndex + 1;
            Collections.swap(players, leftPlayerIndex, rightPlayerIndex);
        }
    }

    private Map<Player, Result> connectPlayerAndPrize(List<Player> players, final List<Result> results) {
        Map<Player, Result> connection = new HashMap<>();
        for (int i = 0; i < players.size(); i++) {
            connection.put(players.get(i), results.get(i));
        }
        return connection;
    }

    private Map<Player, Result> sort(
            final Map<Player, Result> unSortedResults, final List<Player> players) {
        Map<Player, Result> sortedResults = new LinkedHashMap<>();
        for (Player player : players) {
            Result result = unSortedResults.get(player);
            sortedResults.put(player, result);
        }
        return sortedResults;
    }

    public Map<Player, Result> getAllResult() {
        return results;
    }

    public Result getSinglePlayerResult(final Player player) {
        Result result = results.get(player);
        validatePlayerName(result);
        return result;
    }

    private void validatePlayerName(final Result result) {
        if (result == null) {
            throw new NoSuchPlayerException();
        }
    }
}
