package domain;

import domain.ladder.BridgeGenerator;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.Width;
import domain.player.Position;
import java.util.List;

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

    public String matchResult(final String playerName) {
        final Position position = players.getPositionBy(playerName);

        return matchingItems.get(position.value());
    }

    public List<String> getPlayerNames() {
        return players.getNames();
    }

    public Ladder getLadder() {
        return ladder;
    }
}
