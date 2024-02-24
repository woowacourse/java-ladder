package domain.ladderTest;

import domain.Bridge;
import domain.Bridges;
import domain.bridgeConstructstrategy.BridgeConstructStrategy;
import java.util.List;
import java.util.stream.IntStream;

class ContinuousBridgeConstructStrategy implements BridgeConstructStrategy {

    @Override
    public Bridges generate(int count) {
        List<Bridge> bridges = IntStream.range(0, count)
                .mapToObj((i) -> Bridge.BUILT)
                .toList();
        return new Bridges(bridges);
    }
}
