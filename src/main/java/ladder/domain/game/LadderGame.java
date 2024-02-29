package ladder.domain.game;

import ladder.domain.ladder.Ladder;

public class LadderGame {
    private final Ladder ladder;

    public LadderGame(final Ladder ladder) {
        this.ladder = ladder;
    }

    public PlayResult play(final Players players, final Prizes prizes) {
        PlayResult playResult = new PlayResult();

        players.climb(ladder);
        playResult.recordResult(players.getPlayers(), prizes.getPrizes());

        return playResult;
    }
}
