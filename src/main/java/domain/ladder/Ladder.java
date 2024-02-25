package domain.ladder;

import domain.player.Name;
import domain.player.Names;
import domain.ladder.bridgeConstructstrategy.BridgeConstructStrategy;
import domain.result.Result;
import domain.result.Results;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Bridges> bridges;

    public Ladder(BridgeConstructStrategy bridgeConstructStrategy, Names names, Height height) {
        bridges = IntStream.range(0, height.getIntValue())
                .mapToObj((index) -> bridgeConstructStrategy.generate(names.size() - 1))
                .toList();
    }

    public Map<Name, Result> getMatchResult(Names names, Results results) {
        List<Integer> matchIndexes = calculateResult(names);
        Map<Name, Result> matchResults = new HashMap<>();
        for (int index = 0; index < names.size(); index++) {
            matchResults.put(names.get(index), results.get(matchIndexes.get(index)));
        }
        return matchResults;
    }

    private List<Integer> calculateResult(Names names) {
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, names.size())
                .forEach(list::add);
        for (Bridges bridge : bridges) {
            moveEachFloor(list, bridge);
        }
        return list;
    }

    private void moveEachFloor(List<Integer> list, Bridges bridges) {
        IntStream.range(0, bridges.getBridges().size())
                .filter(index -> bridges.getBridges().get(index) == Bridge.BUILT)
                .forEach((bridgeIndex) -> this.swapList(list, bridgeIndex, bridgeIndex + 1));
    }

    private void swapList(List<Integer> list, int prevIndex, int nextIndex) {
        //TODO swapList에 제네릭을 설정하는 것 역시 오버엔지니어링?
        Integer next = list.remove(nextIndex);
        Integer prev = list.remove(prevIndex);
        list.add(prevIndex, next);
        list.add(nextIndex, prev);
    }

    public List<Bridges> getBridge() {
        return Collections.unmodifiableList(bridges);
    }

    public int getLegSize() {
        return bridges.get(0).size() + 1;
    }
}
