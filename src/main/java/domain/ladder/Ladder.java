package domain.ladder;

import domain.player.Names;
import domain.ladder.bridgeConstructstrategy.BridgeConstructStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class Ladder {

    private final List<Bridges> bridges;
    private final Map<Integer, Integer> results;

    public Ladder(BridgeConstructStrategy bridgeConstructStrategy, Names names, Height height) {
        bridges = IntStream.range(0, height.getIntValue())
                .mapToObj((index) -> bridgeConstructStrategy.generate(names.size() - 1))
                .toList();
        results = new IdentityHashMap<>();
        calculateResult(names);
    }

    private void calculateResult(Names names) {
        List<Integer> list = new ArrayList<>();
        IntStream.range(0, names.size())
                .forEach(list::add);
        for (Bridges bridge : bridges) {
            moveEachFloor(list, bridge);
        }
        for (int index = 0; index < names.size(); index++) {
            results.put(index, list.get(index));
        }
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

    public int width() {//TODO 디미터
        return bridges.get(0).getBridges().size();
    }

    public int getResultIndex(int startIndex) {
        return results.get(startIndex);
    }
}
