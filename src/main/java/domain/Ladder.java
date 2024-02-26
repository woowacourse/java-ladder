package domain;

import domain.bridge.BridgeGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Floor> floors;
    private final LadderResults ladderResults;

    private Ladder(List<Floor> floors, LadderResults ladderResults) {

        this.floors = List.copyOf(floors);
        this.ladderResults = ladderResults;
    }

    public static Ladder create(LadderHeight height, PlayerNames playerNames, LadderResults ladderResults, BridgeGenerator bridgeGenerator) {
        List<Floor> floors = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            List<LadderBridge> bridges = bridgeGenerator.generate(calculatePointCount(playerNames));
            floors.add(new Floor(bridges));
        }

        return new Ladder(floors, ladderResults);
    }

    private static int calculatePointCount(PlayerNames playerNames) {
        return playerNames.getCount() - 1;
    }

    public String getLadderResultByIndex(int index) {
        return ladderResults.getValueByIndex(index);
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public int getResultSize() {
        return ladderResults.size();
    }
}
