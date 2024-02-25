package domain.ladder;

import domain.player.Names;
import domain.ladder.bridgeConstructstrategy.BridgeConstructStrategy;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Bridges> bridges;

    public Ladder(BridgeConstructStrategy bridgeConstructStrategy, Names names, Height height) {
        bridges = IntStream.range(0, height.getIntValue())
                .mapToObj((index) -> bridgeConstructStrategy.generate(names.size() - 1))
                .toList();
    }

    public List<Bridges> getBridge() {
        return Collections.unmodifiableList(bridges);
    }

    public int width() {//TODO 디미터
        return bridges.get(0).getBridges().size();
    }
}
