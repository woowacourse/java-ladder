package domain;

import domain.ladder.Ladder;
import domain.ladder.PointGenerator;
import domain.players.Players;
import domain.prize.Prizes;

import java.util.List;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;
    private final Prizes prizes;
    private final LadderGameResult result;

    public LadderGame(final Players players, final int ladderHeight, final List<String> prizes, final PointGenerator pointGenerator) {
        validate(players, prizes);
        this.players = players;
        this.ladder = Ladder.of(players.getPlayerSize(), ladderHeight, pointGenerator);
        this.prizes = Prizes.from(prizes);
        this.result = LadderGameResult.of(players, this.prizes, ladder.ride(players.getPlayerSize()));
    }

    private void validate(final Players players, final List<String> prizes) {
        if (players.getPlayerSize() != prizes.size()) {
            throw new IllegalArgumentException("참여자 수와 당첨 항목의 수는 같아야합니다.");
        }
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Players getPlayers() {
        return players;
    }

    public Prizes getPrizes() {
        return prizes;
    }

    public LadderGameResult getResult() {
        return result;
    }
    
}
