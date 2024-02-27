package domain;

import domain.ladder.BridgeGenerator;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.Width;
import domain.player.Player;
import domain.player.Position;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LadderGame {

    private final Players players;
    private final MatchingItems matchingItems;
    private final Ladder ladder;

    public LadderGame(
            final List<String> playerNames,
            final List<String> matchingItems,
            final int height,
            final BridgeGenerator bridgeGenerator) {
        this.players = new Players(playerNames);
        this.matchingItems = new MatchingItems(matchingItems, players.count());
        this.ladder = Ladder.createByStrategy(
                bridgeGenerator,
                new Height(height),
                Width.from(players)
        );
    }

    public Players play() {
        for (int playerIndex = 0; playerIndex < players.count(); playerIndex++) {
            final int resultPosition = ladder.calculateResultPosition(playerIndex);
            players.setPosition(playerIndex, resultPosition);
        }
        return players;
    }

    public List<GameResult> matchResult(final String playerName, final String selectAll) {
        if (Objects.equals(playerName, selectAll)) {
            return getAllResults();
        }

        final Position position = players.getPositionBy(playerName);
        final String matchingItem = matchingItems.get(position.value());
        final GameResult gameResult = new GameResult(playerName, matchingItem);

        return List.of(gameResult);
    }

    private List<GameResult> getAllResults() {
        final List<GameResult> allResults = new ArrayList<>();
        for (int i = 0; i < players.count(); i++) {
            final Position position = players.getPositionBy(players.getName(i));
            final String matchingItem = matchingItems.get(position.value());
            final GameResult eachResult = new GameResult(players.getName(i), matchingItem);

            allResults.add(eachResult);
        }
        return allResults;
    }

    public List<String> getPlayerNames() {
        return players.getNames();
    }

    public Ladder getLadder() {
        return ladder;
    }
}
