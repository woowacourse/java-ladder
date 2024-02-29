package domain;

import domain.ladder.Ladder;
import domain.player.Players;
import domain.player.Position;
import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final Players players;
    private final MatchingItems matchingItems;
    private final Ladder ladder;

    public LadderGame(final Players players, final MatchingItems matchingItems, final Ladder ladder) {
        this.players = players;
        this.matchingItems = matchingItems;
        this.ladder = ladder;
    }

    public void play() {
        for (int playerIndex = 0; playerIndex < players.count(); playerIndex++) {
            final int resultPosition = ladder.moveFrom(playerIndex);
            players.setPosition(playerIndex, resultPosition);
        }
    }

    public GameResult matchResult(final String playerName) {
        final Position position = players.getPositionBy(playerName);
        final String matchingItem = matchingItems.getBy(position.value());

        return new GameResult(playerName, matchingItem);
    }

    public List<GameResult> matchResultAll() {
        final List<GameResult> allResults = new ArrayList<>();
        for (int i = 0; i < players.count(); i++) {
            final Position position = players.getPositionBy(players.getNameBy(i));
            final String matchingItem = matchingItems.getBy(position.value());
            final GameResult eachResult = new GameResult(players.getNameBy(i), matchingItem);

            allResults.add(eachResult);
        }
        return allResults;
    }

    public List<String> getPlayerNames() {
        return players.getNames();
    }

    public MatchingItems getMatchingItems() {
        return matchingItems;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
