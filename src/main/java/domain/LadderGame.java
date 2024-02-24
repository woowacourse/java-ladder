package domain;

import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final Names names;

    public LadderGame(List<String> userNames, int ladderHeight) {
        names = new Names(userNames);
        int nameCount = names.getNameCount();
        ladder = new Ladder(ladderHeight, nameCount, new BridgeRandomGenerator());
    }

    public List<String> getRawNames() {
        return names.getRawNames();
    }

    public List<List<Boolean>> getRawLadder() {
        return ladder.getRawLadder();
    }
}
