package domain;

import domain.bridge.BridgeGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Floor> floors;

    private Ladder(final List<Floor> floors) {
        this.floors = floors;
    }

    public static Ladder of(final LadderHeight height, final PlayerNames playerNames, final BridgeGenerator bridgeGenerator) {
        List<Floor> floors = new ArrayList<>();
        int bridgeCount = calculateBridgeCount(playerNames);
        for (int i = 0; i < height.getValue(); i++) {
            List<LadderBridge> bridges = bridgeGenerator.generate(bridgeCount);
            floors.add(new Floor(bridges));
        }

        return new Ladder(floors);
    }

    private static int calculateBridgeCount(PlayerNames playerNames) {
        return playerNames.getCount() - 1;
    }

    public List<Floor> getFloors() {
        return Collections.unmodifiableList(floors);
    }
}
