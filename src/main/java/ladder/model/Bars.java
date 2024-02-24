package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bars {
    List<Bar> bars;

    public Bars(List<Bar> bars) {
        this.bars = bars;
    }

    public List<String> calculateLadderResult(Players players) {
        List<String> ladderResult = new ArrayList<>(players.getPlayerNames());

        bars.stream()
                .map(Bar::getLeftPosition)
                .forEach(idx -> Collections.swap(ladderResult, idx, idx + 1));

        return ladderResult;
    }
}
