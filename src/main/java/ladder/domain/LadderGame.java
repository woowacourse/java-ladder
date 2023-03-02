package ladder.domain;

import ladder.domain.ladder.Block;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.domain.player.Player;
import ladder.domain.player.Players;
import ladder.domain.result.Result;
import ladder.domain.result.Results;

import java.util.LinkedHashMap;
import java.util.Map;

public class LadderGame {

    private final Players players;
    private final Results results;
    private final Ladder ladder;

    public LadderGame(final Players players, final Results results, final Ladder ladder) {
        this.players = players;
        this.results = results;
        this.ladder = ladder;
    }

    public Map<Player, Result> getAllResult() {
        Map<Player, Result> allResult = new LinkedHashMap<>();
        for (Player player : players.getPlayers()) {
            Result result = getPlayerResult(player);
            allResult.put(player, result);
        }
        return allResult;
    }

    public Result getPlayerResult(final Player player) {
        for (Line line : ladder.getLines()) {
            moveOnePoint(player, line);
        }
        int playerIndex = player.getPosition().getPosition();
        return results.findByIndex(playerIndex);
    }

    private void moveOnePoint(final Player player, final Line line) {
        int playerIndex = player.getPosition().getPosition();
        if (isLeft(playerIndex, line)) {
            player.moveLeft();
            return;
        }
        if (isRight(playerIndex, line)) {
            player.moveRight();
        }
    }

    private Boolean isLeft(final int playerIndex, final Line line) {
        if (playerIndex == 0) {
            return false;
        }
        int blockIndex = playerIndex - 1;
        Block block = line.getBlockByIndex(blockIndex);
        return block.isExistBlock();
    }

    private Boolean isRight(final int playerIndex, final Line line) {
        int lastPlayerIndex = players.size() - 1;
        if (playerIndex == lastPlayerIndex) {
            return false;
        }
        int blockIndex = playerIndex;
        Block block = line.getBlockByIndex(blockIndex);
        return block.isExistBlock();
    }
}
