package ladder.domain;

import java.util.List;

public class LadderGame {

    private final PlayerNames playerNames;
    private final Ladder ladder;
    private final LadderProperty ladderProperty;

    public LadderGame(List<String> names, int height) {
        this.playerNames = new PlayerNames(names);
        this.ladderProperty = new LadderProperty(names.size() - 1, height);

        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
        LadderMaker ladderMaker = new LadderMaker(ladderProperty, booleanGenerator);

        this.ladder = ladderMaker.generate();
    }

    public List<String> getNames () {
        return playerNames.getNames();
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }
}
