package domain;

import domain.Players;
import domain.ladder.BridgeGenerator;
import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.RandomBridgeGenerator;
import domain.ladder.Width;
import java.util.List;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;

    public LadderGame(final List<String> playerNames, final int height, BridgeGenerator bridgeGenerator) {
        this.players = new Players(playerNames);
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

    public List<String> getPlayerNames() {
        return players.getNames();
    }

    public Ladder getLadder() {
        return ladder;
    }
}
