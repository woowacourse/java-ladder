package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Bridges> ladder;

    private Ladder(List<Bridges> ladder) {
        this.ladder = ladder;
    }

    public static Ladder createByStrategy(BridgeGenerator bridgeGenerator, Height height, Players players) {
        final List<Bridges> ladder = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            ladder.add(Bridges.createByStrategy(bridgeGenerator, players));
        }
        return new Ladder(ladder);
    }

    public List<Bridges> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
