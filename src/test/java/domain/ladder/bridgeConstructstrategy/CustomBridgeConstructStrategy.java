package domain.ladder.bridgeConstructstrategy;

import domain.ladder.Bridge;
import domain.ladder.Bridges;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class CustomBridgeConstructStrategy implements BridgeConstructStrategy {

    private final List<List<Bridge>> bridges;

    public CustomBridgeConstructStrategy(List<List<Bridge>> bridges) {
        this.bridges = new LinkedList<>(bridges);
    }

    @Override
    public Bridges generate(int count) {
        List<Bridge> firstBridges = bridges.remove(0);
        List<Bridge> generatedBridges = IntStream.range(0, count)
                .mapToObj(index -> firstBridges.get(index))
                .toList();
        return new Bridges(generatedBridges);
    }
}
