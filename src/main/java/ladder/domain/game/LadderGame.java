package ladder.domain.game;

import ladder.domain.ladder.Ladder;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final List<String> prizes;

    public LadderGame(final Ladder ladder, final Players players, final List<String> prizes) {
        validateLadderGame(players.count(), prizes.size());
        this.ladder = ladder;
        this.players = players;
        this.prizes = new ArrayList<>(prizes);
    }

    private void validateLadderGame(final int playerCount, final int prizeCount) {
        if (playerCount != prizeCount) {
            throw new IllegalArgumentException("사다리 게임의 참여하는 사람의 수와 상품의 수는 같아야합니다.");
        }
    }

    public PlayResult play() {
        players.climb(ladder);

        return new PlayResult(players.getPlayers(), prizes);
    }
}
