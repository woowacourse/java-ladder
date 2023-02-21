package domain.game;

import domain.ladder.Ladder;
import domain.ladder.LadderFactory;
import domain.value.Height;
import domain.value.Names;
import domain.value.Width;
import domain.value.WinningEntries;

public class LadderGameFactory {

    private final LadderFactory ladderFactory;

    public LadderGameFactory(final LadderFactory ladderFactory) {
        this.ladderFactory = ladderFactory;
    }

    public LadderGame createGame(final Names names, final WinningEntries winningEntries, final Height height) {
        Ladder ladder = ladderFactory.createLadder(Width.of(names.size() - 1), height);
        return new LadderGame(ladder, names, winningEntries);
    }
}
