package domain;

import domain.ladder.Ladder;
import domain.ladder.PointGenerator;
import domain.players.Player;
import domain.players.Players;
import domain.prize.Prize;
import domain.prize.Prizes;

import java.util.List;

public class LadderGame {

    private final Players players;
    private final Ladder ladder;
    private final Prizes prizes;
    private final LadderGameResult result;

    public LadderGame(final List<String> playerNames, final int ladderHeight, final List<String> prizeValues, final PointGenerator pointGenerator) {
        validate(playerNames, prizeValues);
        this.players = Players.valueOf(playerNames);
        this.ladder = Ladder.of(playerNames.size(), ladderHeight, pointGenerator);
        this.prizes = Prizes.from(prizeValues);
        this.result = LadderGameResult.of(players, this.prizes, ladder.ride(playerNames.size()));
    }

    private void validate(final List<String> playerNames, final List<String> prizes) {
        if (playerNames.size() != prizes.size()) {
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

    public Prize getPersonalResult(String name) {
        Player player = players.getPlayerByName(name);
        return result.getPersonalResult(player);
    }

}
