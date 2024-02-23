package domain;

import domain.bridgeConstructstrategy.BridgeConstructStrategy;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Bridges> bridges;

    public Ladder(BridgeConstructStrategy bridgeConstructStrategy, Names names, Height height) {
        bridges = IntStream.range(0, height.getIntValue()) // TODO for 문과 차이점 비교
                .mapToObj((index) -> bridgeConstructStrategy.generate(names.size() - 1))
                .toList();
    }

    public List<Bridges> getBridge() {
        return Collections.unmodifiableList(bridges);
    }
}
