package domain;

import domain.entries.WinningEntries;
import domain.ladder.Ladder;
import domain.ladder.PointGenerator;
import domain.players.Players;

import java.util.List;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;
    private final WinningEntries winningEntries;

    public LadderGame(final Players players, final int ladderHeight, final List<String> winningEntries, final PointGenerator pointGenerator) {
        validate(players, winningEntries);
        this.players = players;
        this.ladder = Ladder.of(players.getPlayerSize(), ladderHeight, pointGenerator);
        this.winningEntries = WinningEntries.from(winningEntries);
    }

    private void validate(final Players players, final List<String> winningEntries) {
        if (players.getPlayerSize() != winningEntries.size()) {
            throw new IllegalArgumentException("참여자 수와 당첨 항목의 수는 같아야합니다.");
        }
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Players getPlayers() {
        return players;
    }

    public WinningEntries getWinningEntries() {
        return winningEntries;
    }

}
