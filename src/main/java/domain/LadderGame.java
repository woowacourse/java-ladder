package domain;

import domain.ladder.Ladder;
import domain.player.Names;
import domain.result.Prizes;

public class LadderGame {
    private final Names names;
    private final Prizes prizes;
    private final Ladder ladder;
    private GameResult gameResult = null;

    public LadderGame(Names names, Prizes prizes, Ladder ladder) {
        this.names = names;
        this.prizes = prizes;
        this.ladder = ladder;
    }

    public GameResult createGameResult() {
        if (gameResult == null) {
            gameResult = new GameResult(names, prizes, ladder);
        }
        return gameResult;
    }

    public Names getNames() {
        return names;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Prizes getResult() {
        return prizes;
    }
}
