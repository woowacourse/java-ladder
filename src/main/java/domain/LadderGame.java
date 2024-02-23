package domain;

import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final Names names;

    public LadderGame(List<String> userNames, int ladderHeight) {
        names = new Names(userNames);
        int nameCount = names.getNameCount();
        Height height = new Height(ladderHeight);
        Width width = new Width(nameCount);
        ladder = new Ladder(height, width, new BridgeRandomGenerator());
    }

    public String getLadderString() {
        return LadderPrinter.from(ladder);
    }

    public String getNamesString() {
        return NamesPrinter.from(names);
    }
}
