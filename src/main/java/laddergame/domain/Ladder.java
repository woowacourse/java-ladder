package laddergame.domain;

import java.util.LinkedHashMap;
import laddergame.domain.strategy.BuildStrategy;

public class Ladder {
    private final Lines lines;
    private final Players players;
    private final Height height;
    private final PlayersResults playersResults;

    public Ladder(
            final Players players, final Height height, final Results results, final BuildStrategy pointBuildStrategy) {
        this.lines = Lines.from(height, players, pointBuildStrategy);
        this.players = players;
        this.height = height;
        this.playersResults = makeResults(results);
    }

    public Result find(final String name) {
        return playersResults.playerResults().get(players.getPlayerByName(name));
    }

    private PlayersResults makeResults(final Results results) {
        LinkedHashMap<Player, Result> playerResultMap = new LinkedHashMap<>();
        for (int playerIndex = 0; playerIndex < players.getPlayersSize(); playerIndex++) {
            final int resultIndex = findResult(playerIndex);
            playerResultMap.put(players.getPlayers().get(playerIndex), results.getResults().get(resultIndex));
        }
        return new PlayersResults(playerResultMap);
    }

    private int findResult(int playerIndex) {
        for (int nowHeight = 0; nowHeight < height.getHeight(); nowHeight++) {
            Direction direction = lines.getDirection(nowHeight, playerIndex);
            playerIndex = playerIndex + direction.getMovement();
        }
        return playerIndex;
    }

    public int getLadderSize() {
        return lines.getSize();
    }

    public Line getLine(final int lineIndex) {
        return lines.getLine(lineIndex);
    }

    public PlayersResults getPlayersResults() {
        return playersResults;
    }
}
