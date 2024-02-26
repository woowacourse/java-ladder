package laddergame.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import laddergame.domain.strategy.BuildStrategy;

public class Ladder {
    private final List<Line> lines;
    private final Players players;
    private final Height height;
    private final PlayersResults playersResults;

    public Ladder(
            final Players players, final Height height, final Results results, final BuildStrategy pointBuildStrategy) {
        this.lines = IntStream.range(0, height.getHeight())
                .mapToObj(i -> new Line(players.getPlayersSize(), pointBuildStrategy))
                .collect(Collectors.toList());
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
            Direction direction = lines.get(nowHeight).getDirection(playerIndex);
            playerIndex = playerIndex + direction.getMovement();
        }
        return playerIndex;
    }

    public int getLadderSize() {
        return lines.size();
    }

    public List<Line> getLines() {
        return lines;
    }

    public PlayersResults getPlayersResults() {
        return playersResults;
    }
}
