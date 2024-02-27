package domain;

import domain.ladder.Ladder;
import domain.ladder.attirbute.Direction;
import domain.player.Name;
import domain.player.Players;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class GameBoard {
    private final Players players;
    private final Ladder ladder;
    private final Prizes prizes;
    private final LinkedHashMap<Name, Prize> gameResults;

    public GameBoard(Players players, Ladder ladder, Prizes prizes) {
        this.players = players;
        this.ladder = ladder;
        this.prizes = prizes;
        this.gameResults = generateGameResult();
    }

    public List<Direction> getDirectionsAtHorizontalIndex(int index) {
        return ladder.getDirectionsAtHorizontalIndex(index);
    }

    private LinkedHashMap<Name, Prize> generateGameResult() {
        LinkedHashMap<Name, Prize> results = new LinkedHashMap<>();
        IntStream.range(0, players.getPlayerCount())
                 .forEach(value -> results.put(getPlayerNameAtStartingIndex(value), getPrizeAtStartingIndex(value)));
        return results;
    }

    private Name getPlayerNameAtStartingIndex(int value) {
        return players.getPlayerNames()
                      .get(value);
    }

    private Prize getPrizeAtStartingIndex(int value) {
        return prizes.getValue()
                     .get(ladder.moveCoordinateToResultPoint(value, 0));
    }

    public Map<Name, Prize> getAllPlayerResult() {
        return gameResults;
    }

    public Players getPlayers() {
        return players;
    }

    public int getLadderHeight() {
        return ladder.getHeight();
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Prizes getPrizes() {
        return prizes;
    }

}
