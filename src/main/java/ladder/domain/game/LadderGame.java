package ladder.domain.game;

import ladder.domain.ladder.Ladder;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final Prizes prizes;

    public LadderGame(final Ladder ladder, final Players players, final Prizes prizes) {
        this.ladder = ladder;
        this.players = players;
        this.prizes = prizes;
    }

    public PlayResult play() {
        PlayResult playResult = new PlayResult();

        players.climb(ladder);
        playResult.recordResult(players.getPlayers(), prizes.getPrizes());

        return playResult;
    }
}
