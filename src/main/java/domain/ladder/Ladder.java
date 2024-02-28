package domain.ladder;

import domain.ladder.bridgeConstructstrategy.BridgeConstructStrategy;
import domain.player.Names;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Bridges> bridges;
    private final Map<Integer, Integer> finalResult;

    public Ladder(BridgeConstructStrategy bridgeConstructStrategy, Names names, Height height) {
        bridges = IntStream.range(0, height.getIntValue())
                .mapToObj((index) -> bridgeConstructStrategy.generate(names.size() - 1))
                .toList();
        this.finalResult = matchStartIndexToEndIndex();
    }

    private Map<Integer, Integer> matchStartIndexToEndIndex() {
        List<Integer> indexes = IntStream.range(0, getLegSize())
                .boxed()
                .collect(Collectors.toList());
        bridges.forEach(bridge -> bridge.moveAllMovableIndex(indexes));
        return IntStream.range(0, getLegSize())
                .boxed()
                .collect(Collectors.toMap(indexes::get,Function.identity()));
    }

    public int matchedIndex(int startIndex) {
        return finalResult.get(startIndex);
    }

    private int getWidth() {
        return bridges.get(0).size();
    }

    public int getLegSize() {
        return getWidth() + 1;
    }

    public List<Bridges> getBridge() {
        return bridges;
    }
}
