package laddergame.domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import laddergame.domain.strategy.BuildStrategy;

public class Ladder {
    private final List<Line> lines;
    private final Players players;
    private final Height height;
    private final Map<Player, Result> playersResults = new LinkedHashMap<>();

    public Ladder(
            final Players players, final Height height, final Results results, final BuildStrategy pointBuildStrategy) {
        this.lines = IntStream.range(0, height.getHeight())
                .mapToObj(i -> new Line(players.getPlayers().size(), pointBuildStrategy))
                .collect(Collectors.toList());
        this.players = players;
        this.height = height;
        makeResults(results);
    }

    public Result find(final String name) {
        return playersResults.get(players.getPlayerByName(name));
    }

    private void makeResults(final Results results) {
        for (int playerIndex = 0; playerIndex < players.getPlayers().size(); playerIndex++) {
            final int resultIndex = findResult(playerIndex);
            playersResults.put(players.getPlayers().get(playerIndex), results.getResults().get(resultIndex));
        }
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

    public Map<Player, Result> getPlayersResults() {
        return playersResults;
    }
}
