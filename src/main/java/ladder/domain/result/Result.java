package ladder.domain.result;

import ladder.domain.ladder.Block;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.player.PlayerName;
import ladder.domain.player.Players;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;

import java.util.*;

public class Result {

    private final Map<PlayerName, Prize> results;

    public Result(final Players players, final Prizes prizes, final Ladder ladder) {
        this.results = makeResult(players, prizes, ladder);
    }

    private Map<PlayerName, Prize> makeResult(Players players, Prizes prizes, Ladder ladder) {
        List<PlayerName> playerNames = new ArrayList<>(players.getPlayers());
        for (Line line : ladder.getLines()) {
            moveOneLine(playerNames, line);
        }
        Map<PlayerName, Prize> unSortedResults = connectPlayerAndPrize(playerNames, prizes.getPrizes());
        return sort(unSortedResults, players.getPlayers());
    }

    private void moveOneLine(List<PlayerName> playerNames, Line line) {
        for (int i = 0; i < line.getBlocks().size(); i++) {
            Block block = line.getBlocks().get(i);
            moveEachPlayer(playerNames, i, block);
        }
    }

    private void moveEachPlayer(List<PlayerName> playerNames, int blockIndex, Block block) {
        if (block.isExistBlock()) {
            int leftPlayerIndex = blockIndex;
            int rightPlayerIndex = blockIndex + 1;
            Collections.swap(playerNames, leftPlayerIndex, rightPlayerIndex);
        }
    }

    private Map<PlayerName, Prize> connectPlayerAndPrize(List<PlayerName> playerNames, List<Prize> prizes) {
        Map<PlayerName, Prize> connection = new HashMap<>();
        for (int i = 0; i < playerNames.size(); i++) {
            connection.put(playerNames.get(i), prizes.get(i));
        }
        return connection;
    }

    private Map<PlayerName, Prize> sort(Map<PlayerName, Prize> unSortedResults, List<PlayerName> playerNames) {
        Map<PlayerName, Prize> sortedResults = new LinkedHashMap<>();
        for (PlayerName playerName : playerNames) {
            Prize prize = unSortedResults.get(playerName);
            sortedResults.put(playerName, prize);
        }
        return sortedResults;
    }

    public Map<PlayerName, Prize> getAllResult() {
        return results;
    }
}
