package domain.game;

import domain.ladder.Ladder;
import domain.value.*;

import java.util.stream.Collectors;

public class LadderGame {

    private static final Name FOR_ALL_NAME = new Name("all");

    private final Ladder ladder;
    private final Names names;
    private final WinningEntries winningEntries;
    private final State state;

    public LadderGame(final Ladder ladder, final Names names, final WinningEntries winningEntries) {
        this.ladder = ladder;
        this.names = names;
        this.winningEntries = winningEntries;
        state = State.prepared();
    }

    public LadderGameResult goDownLadder(final Name name) {
        if (name.equals(FOR_ALL_NAME)) {
            return goDownForAllParticipants();
        }
        return goDownForParticipant(name);
    }

    private LadderGameResult goDownForAllParticipants() {
        state.set(GameState.END);
        return new LadderGameResult(names.names()
                .stream()
                .collect(Collectors.toUnmodifiableMap(
                        name -> name,
                        name -> winningEntries.get(
                                ladder.goDown(Position.of(names.indexOf(name))).value()
                        )))
        );
    }

    private LadderGameResult goDownForParticipant(final Name name) {
        state.set(GameState.PROCEEDING);
        Position start = Position.of(names.indexOf(name));
        Position end = ladder.goDown(start);
        WinningEntry winningEntry = winningEntries.get(end.value());
        return new LadderGameResult(name, winningEntry);
    }

    public boolean isEnd() {
        return state.isEnd();
    }
}
