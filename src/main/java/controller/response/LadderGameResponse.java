package controller.response;

import domain.game.LadderGame;
import domain.ladder.Ladder;
import domain.value.Names;
import domain.value.WinningEntries;

public class LadderGameResponse {

    private final Ladder ladder;
    private final Names names;
    private final WinningEntries winningEntries;

    public LadderGameResponse(final LadderGame game) {
        this.ladder = game.ladder();
        this.names = game.names();
        this.winningEntries = game.winningEntries();
    }

    public Ladder ladder() {
        return ladder;
    }

    public Names names() {
        return names;
    }

    public WinningEntries winningEntries() {
        return winningEntries;
    }
}
