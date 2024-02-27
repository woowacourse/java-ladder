package domain;

import java.util.List;
import java.util.stream.IntStream;

public class LadderGame {
    private final Ladder ladder;
    private final Names names;
    private final LadderResults ladderResults;

    public LadderGame(String userNames, String rawLadderResults, int ladderHeight, BridgesGenerator generator) {
        NamesCreator namesCreator = new NamesCreator();
        LadderResultCreator ladderResultCreator = new LadderResultCreator();
        names = namesCreator.create(userNames);
        ladderResults = ladderResultCreator.create(rawLadderResults);
        int nameCount = names.getNameCount();
        Height height = new Height(ladderHeight);
        Width width = new Width(nameCount);
        ladder = new Ladder(height, width, generator);
    }

    public Names getNames() {
        return names;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderResults getLadderResults() {
        return ladderResults;
    }

    public LadderGameResult calculateLadderGameResult() {
        ladder.getLadder().stream()
                .map(Bridges::getBridges)
                .forEach(this::swapNames);
        return new LadderGameResult(names, ladderResults);
    }

    private void swapNames(List<Boolean> bridges) {
        IntStream.range(0, bridges.size())
                .forEach(index -> swapIfBridgeExist(bridges.get(index), index));
    }

    private void swapIfBridgeExist(Boolean bridge, int index) {
        if (bridge) {
            names.swapNamePosition(index + 1);
        }
    }
}
