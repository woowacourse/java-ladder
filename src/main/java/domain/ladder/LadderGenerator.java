package domain.ladder;

import domain.ladder.strategy.BridgeGenerator;
import domain.player.PlayerNames;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderGenerator {
    private final LadderHeight ladderHeight;
    private final PlayerNames playerNames;
    private final BridgeGenerator bridgeGenerator;

    public LadderGenerator(
            final LadderHeight ladderHeight,
            final PlayerNames playerNames,
            final BridgeGenerator bridgeGenerator
    ) {
        this.ladderHeight = ladderHeight;
        this.playerNames = playerNames;
        this.bridgeGenerator = bridgeGenerator;
    }

    public List<Floor> generateLadder() {
        List<Floor> floors = new ArrayList<>();
        int bridgeCount = calculateBridgeCount(playerNames);
        for (int i = 0; i < ladderHeight.getValue(); i++) {
            List<LadderBridge> bridges = bridgeGenerator.generate(bridgeCount);
            floors.add(new Floor(bridges));
        }
        return Collections.unmodifiableList(floors);
    }

    private static int calculateBridgeCount(final PlayerNames playerNames) {
        return playerNames.getPlayerCount() - 1;
    }
}
