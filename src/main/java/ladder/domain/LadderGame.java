package ladder.domain;

import java.util.List;

public class LadderGame {

    private final PlayerNames playerNames;
    private final Ladder ladder;
    private final LadderSize ladderSize;
    private final Result result;

    public LadderGame(List<String> names, int height, List<String> results) {
        this.playerNames = new PlayerNames(names);
        this.ladderSize = new LadderSize(names.size() - 1, height);

        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
        LadderMaker ladderMaker = new LadderMaker(ladderSize, booleanGenerator);

        this.ladder = ladderMaker.generate();
        this.result = new Result(results,names.size());
    }

    public List<String> getNames () {
        return playerNames.getNames();
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }

    public List<String> getResults() {
        return result.getResults();
    }
}
