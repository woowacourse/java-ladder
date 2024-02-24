package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bars {
    List<Bar> bars;

    private Bars(List<Bar> bars) {
        this.bars = bars;
    }

    public static Bars from(List<Integer> positions) {
        return new Bars(positions.stream()
                .map(Bar::new)
                .toList());
    }

    public List<String> calculateChangedLadderResult(List<String> ladderResult) {
        List<String> changedLadderResult = new ArrayList<>(ladderResult);

        bars.stream()
                .map(Bar::getLeftPosition)
                .forEach(idx -> Collections.swap(changedLadderResult, idx, idx + 1));

        return changedLadderResult;
    }
}
