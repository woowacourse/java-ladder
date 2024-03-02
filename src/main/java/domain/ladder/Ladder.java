package domain.ladder;

import domain.ladder.bridgeConstructstrategy.LineConstructStrategy;
import domain.player.Names;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Line> lines;
    private final Map<Integer, Integer> matchedIndexes;

    public Ladder(LineConstructStrategy lineConstructStrategy, Names names, Height height) {
        lines = IntStream.range(0, height.getIntValue())
                .mapToObj((index) -> lineConstructStrategy.generate(names.size() - 1))
                .toList();
        this.matchedIndexes = matchStartIndexToEndIndex();
    }

    private Map<Integer, Integer> matchStartIndexToEndIndex() {
        List<Integer> indexes = IntStream.range(0, getLegSize())
                .boxed()
                .collect(Collectors.toList());
        lines.forEach(bridge -> bridge.moveAllMovableIndex(indexes));
        return IntStream.range(0, getLegSize())
                .boxed()
                .collect(Collectors.toMap(indexes::get, Function.identity()));
    }

    public int getMatchedIndex(int startIndex) {
        return matchedIndexes.get(startIndex);
    }

    public int getLegSize() {
        return lines.get(0).size() + 1;
    }

    public List<Line> getLines() {
        return lines;
    }
}
