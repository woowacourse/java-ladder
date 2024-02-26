package domain;

import domain.bridgeConstructstrategy.BridgeConstructStrategy;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {

    private final Names names;
    private final Prizes prizes;
    private final List<Bridges> bridges;

    // TODO 파라미터가 너무 많음. 정적 팩토리 메서드나 Builder 패턴 도입 고민
    public Ladder(BridgeConstructStrategy bridgeConstructStrategy, Names names, Prizes prizes, Height height) {
        this.names = names;
        this.prizes = prizes;
        bridges = IntStream.range(0, height.getIntValue())
                .mapToObj((index) -> bridgeConstructStrategy.generate(names.size() - 1))
                .toList();
    }

    public List<Bridges> getBridge() {
        return Collections.unmodifiableList(bridges);
    }

    // TODO Prize 객체를 사용해서 반환하는 것도 고민
    public Result calculateResult(Name name) {
        int index = names.findIndex(name.getName());
        for (Bridges bridge : bridges) {
            if (bridge.canCrossToLeft(index)) {
                index--;
                continue;
            }
            if (bridge.canCrossToRight(index)) {
                index++;
            }
        }
        return new Result(name, prizes.findByIndex(index));
    }

    public Results calculateAllResult() {
        List<Name> names = this.names.getNames();
        List<Result> results = names.stream()
                .map((this::calculateResult))
                .toList();
        return new Results(results);
    }
}
