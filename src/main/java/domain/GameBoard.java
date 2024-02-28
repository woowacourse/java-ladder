package domain;

import domain.ladder.Ladder;
import domain.ladder.attirbute.Direction;
import domain.player.Name;
import domain.player.Players;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class GameBoard {
    private static final int HEIGHT_STARTING_INDEX = 0;
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
                     .get(ladder.moveCoordinateToResultPoint(value, HEIGHT_STARTING_INDEX));
    }

    public Map<Name, Prize> searchAllPlayerResult() {
        return Collections.unmodifiableMap(gameResults);
    }

    public String searchOnePlayerResult(Name targetName) {
        try {
            return gameResults.get(players.searchPlayer(targetName)
                                          .name())
                              .toString();
        } catch (Exception e) {
            return e.getMessage();
        }
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
