package ladder.domain;

import java.util.List;

public class LadderGame {

    private final PlayerNames playerNames;
    private final Ladder ladder;
    private final LadderSize ladderSize;

    public LadderGame(List<String> names, int height) {
        this.playerNames = new PlayerNames(names);
        this.ladderSize = new LadderSize(names.size() - 1, height);

        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
        LadderMaker ladderMaker = new LadderMaker(ladderSize, booleanGenerator);

        this.ladder = ladderMaker.generate();
    }

    public List<String> getNames () {
        return playerNames.getNames();
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }
}
