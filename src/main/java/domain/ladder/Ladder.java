package domain.ladder;

import domain.ladder.strategy.BridgeGenerator;
import domain.player.Players;
import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final LadderHeight ladderHeight;
    private final Players players;
    private final BridgeGenerator bridgeGenerator;

    public Ladder(final LadderHeight ladderHeight, final Players players, final BridgeGenerator bridgeGenerator) {
        this.ladderHeight = ladderHeight;
        this.players = players;
        this.bridgeGenerator = bridgeGenerator;
    }

    public List<Floor> createFloors() {
        List<Floor> floors = new ArrayList<>();
        int bridgeCount = calculateBridgeCount(players);
        for (int i = 0; i < ladderHeight.getValue(); i++) {
            List<LadderBridge> bridges = bridgeGenerator.generate(bridgeCount);
            floors.add(new Floor(bridges));
        }
        return floors;
    }

    private static int calculateBridgeCount(final Players players) {
        return players.getPlayerCount() - 1;
    }
}
