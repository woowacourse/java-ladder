package model.ladderGame;

import model.ladder.Ladder;
import model.players.Players;
import model.players.Position;
import model.prize.Prize;
import model.prize.Prizes;

public class LadderGame {
    private final Players players;
    private final Ladder ladder;
    private final Prizes prizes;

    public LadderGame(final Players players, Ladder ladder, final Prizes prizes) {
        this.players = players;
        this.ladder = ladder;
        this.prizes = prizes;
    }

    public Prize move(String name) {
        Position position = players.findPositionByName(name);
        return prizes.getPrizeByIndex(ladder.move(position));
    }
}

