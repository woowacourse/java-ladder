package domain;

import domain.ladder.Ladder;
import domain.ladder.attirbute.Direction;
import domain.player.PlayerName;
import domain.player.Players;
import domain.prize.PrizeName;
import domain.prize.PrizeNames;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class GameBoard {
    private static final int HEIGHT_STARTING_INDEX = 0;
    private final Players players;
    private final Ladder ladder;
    private final PrizeNames prizeNames;
    private final LinkedHashMap<PlayerName, PrizeName> gameResults;

    public GameBoard(Players players, Ladder ladder, PrizeNames prizeNames) {
        this.players = players;
        this.ladder = ladder;
        this.prizeNames = prizeNames;
        this.gameResults = generateGameResult();
    }

    public List<Direction> getDirectionsAtHorizontalIndex(int index) {
        return ladder.getDirectionsAtHorizontalIndex(index);
    }

    private LinkedHashMap<PlayerName, PrizeName> generateGameResult() {
        LinkedHashMap<PlayerName, PrizeName> results = new LinkedHashMap<>();
        IntStream.range(0, players.getPlayerCount())
                 .forEach(value -> results.put(getPlayerNameAtStartingIndex(value), getPrizeAtStartingIndex(value)));
        return results;
    }

    private PlayerName getPlayerNameAtStartingIndex(int value) {
        return players.getPlayerNames()
                      .get(value);
    }

    private PrizeName getPrizeAtStartingIndex(int value) {
        return prizeNames.getValue()
                         .get(ladder.moveCoordinateToResultPoint(value, HEIGHT_STARTING_INDEX));
    }

    public Map<PlayerName, PrizeName> searchAllPlayerResult() {
        return Collections.unmodifiableMap(gameResults);
    }

    public String searchOnePlayerResult(PlayerName targetPlayerName) {
        try {
            return gameResults.get(players.searchPlayer(targetPlayerName)
                                          .playerName())
                              .getValue();
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

    public PrizeNames getPrizes() {
        return prizeNames;
    }

}
