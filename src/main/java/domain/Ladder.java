package domain;

import domain.bridge.BridgeGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Floor> floors;

    private Ladder(List<Floor> floors) {
        this.floors = floors;
    }

    public static Ladder create(LadderHeight height, PlayerNames playerNames, BridgeGenerator bridgeGenerator) {
        List<Floor> floors = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            List<LadderBridge> bridges = bridgeGenerator.generate(calculatePointCount(playerNames));
            floors.add(new Floor(bridges));
        }

        return new Ladder(floors);
    }

    private static int calculatePointCount(PlayerNames playerNames) {
        return playerNames.getCount() - 1;
    }

    public List<Floor> getFloors() {
        return Collections.unmodifiableList(floors);
    }


}
