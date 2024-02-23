package domain;

import java.util.List;
import view.LadderPrinter;
import view.NamesPrinter;

public class LadderGame {
    private final Ladder ladder;
    private final Names names;

    public LadderGame(List<String> userNames, int ladderHeight) {
        names = new Names(userNames);
        int nameCount = names.getNameCount();
        ladder = new Ladder(ladderHeight, nameCount, new BridgeRandomGenerator());
    }

    public String getLadderString() {
        List<List<Boolean>> rawLadder = ladder.getRawLadder();
        return LadderPrinter.from(rawLadder);
    }

    public String getNamesString() {
        List<String> rawNames = names.getRawNames();
        return NamesPrinter.from(rawNames);
    }
}
