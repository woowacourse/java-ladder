package domain;

public class LadderGame {
    private final Ladder ladder;
    private final Names names;

    public LadderGame(String userNames, int ladderHeight) {
        names = new Names(userNames);
        int nameCount = names.getNameCount();
        Height height = new Height(ladderHeight);
        Width width = new Width(nameCount);
        ladder = new Ladder(height, width, new RowInfoRandomGenerator());
    }

    public String getLadderString() {
        return LadderString.from(ladder);
    }

    public String getNamesString() {
        return NamesString.from(names);
    }
}
