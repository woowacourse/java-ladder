package domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderFactory {

    public static Ladder createByStrategy(BridgeGenerator bridgeGenerator, Height height, Width width) {
        final List<Floor> ladder = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            ladder.add(FloorFactory.createByStrategy(bridgeGenerator, width));
        }
        return new Ladder(ladder);
    }
}
