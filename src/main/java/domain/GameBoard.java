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
        for (int currentIndex = 0; currentIndex < players.getPlayerCount(); currentIndex++) {
            results.put(getPlayerNameAtStartingIndex(currentIndex), getPrizeResultFromStartingIndex(currentIndex));
        }
        return results;
    }

    private PlayerName getPlayerNameAtStartingIndex(int index) {
        return players.getPlayerNameAtStartingIndex(index);
    }

    private PrizeName getPrizeResultFromStartingIndex(int index) {
        return prizeNames.getPrizeNameInIndex(ladder.moveCoordinateToResultPoint(index, HEIGHT_STARTING_INDEX));
    }

    public Map<PlayerName, PrizeName> searchAllPlayerResult() {
        return Collections.unmodifiableMap(gameResults);
    }

    public String searchOnePlayerResult(PlayerName targetPlayerName) {
        try {
            return searchFromGameResultByPlayerName(targetPlayerName);
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    private String searchFromGameResultByPlayerName(PlayerName targetPlayerName) {
        return gameResults.get(players.searchPlayer(targetPlayerName)
                        .playerName())
                .getValue();
    }

    public List<PlayerName> getGamePlayerNames() {
        return players.getPlayerNames();
    }

    public int getLadderHeight() {
        return ladder.getHeight();
    }

    public List<PrizeName> getPrizeNames() {
        return prizeNames.getValue();
    }

}
