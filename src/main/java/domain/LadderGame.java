package domain;

public class LadderGame {
    private final Ladder ladder;
    private final Names names;

    public LadderGame(String userNames, int ladderHeight) {
        NameCreator nameCreator = new NameCreator();
        names = nameCreator.create(userNames);
        int nameCount = names.getNameCount();
        Height height = new Height(ladderHeight);
        Width width = new Width(nameCount);
        ladder = new Ladder(height, width, new BridgesRandomGenerator());
    }

    public Names getNames() {
        return names;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
