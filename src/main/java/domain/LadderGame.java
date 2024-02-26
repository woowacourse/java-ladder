package domain;

import domain.GameResult;
import domain.ladder.Ladder;
import domain.player.Names;
import domain.result.Results;

public class LadderGame {
    private final Names names;
    private final Results results;
    private final Ladder ladder;
    private final GameResult gameResult;

    public LadderGame(Names names, Results results, Ladder ladder) {
        this.names = names;
        this.results = results;
        this.ladder = ladder;
        this.gameResult = new GameResult(names, results, ladder);
    }

    public Names getNames() {
        return names;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Results getResult() {
        return results;
    }
}
