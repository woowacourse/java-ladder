package domain.ladder;

import domain.ladder.strategy.BridgeGenerator;
import domain.player.Players;
import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Floor> floors;

    private Ladder(final List<Floor> floors) {
        this.floors = List.copyOf(floors);
    }

    public static Ladder of(final LadderHeight height, final Players players, final BridgeGenerator bridgeGenerator) {
        List<Floor> floors = new ArrayList<>();
        int bridgeCount = calculateBridgeCount(players);
        for (int i = 0; i < height.getValue(); i++) {
            List<LadderBridge> bridges = bridgeGenerator.generate(bridgeCount);
            floors.add(new Floor(bridges));
        }

        return new Ladder(floors);
    }

    private static int calculateBridgeCount(Players players) {
        return players.getPlayerCount() - 1;
    }

    public List<Floor> getFloors() {
        return floors;
    }
}
