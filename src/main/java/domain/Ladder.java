package domain;

import domain.bridgeConstructstrategy.BridgeConstructStrategy;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final Names names;
    private final Prizes prizes;
    private final List<Bridges> bridges;

    public Ladder(BridgeConstructStrategy bridgeConstructStrategy, Names names, Prizes prizes, Height height) {
        this.names = names;
        this.prizes = prizes;
        bridges = IntStream.range(0, height.getHeight())
                .mapToObj((index) -> bridgeConstructStrategy.generate(names.size() - 1))
                .toList();
    }

    public Result calculateResult(Name name) {
        int prizeIndex = names.findIndex(name.getName());
        for (Bridges bridge : bridges) {
            prizeIndex = calculateNextIndex(prizeIndex, bridge);
        }
        Prize prize = prizes.findByIndex(prizeIndex);
        return new Result(name, prize);
    }

    private int calculateNextIndex(int index, Bridges bridge) {
        if (bridge.canCrossToLeft(index)) {
            return index - 1;
        }
        if (bridge.canCrossToRight(index)) {
            return index + 1;
        }
        return index;
    }

    public Results calculateAllResult() {
        List<Name> names = this.names.getNames();
        List<Result> results = names.stream()
                .map((this::calculateResult))
                .toList();
        return new Results(results);
    }

    public List<Bridges> getBridge() {
        return Collections.unmodifiableList(bridges);
    }
}
