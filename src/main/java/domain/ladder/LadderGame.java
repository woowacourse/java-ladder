package domain.ladder;

import domain.Prizes;
import domain.player.Players;


public class LadderGame {
    private final Ladder ladder;
    private final Players players;
    private final Prizes prizes;

    public LadderGame(Ladder ladder, Players players, Prizes prizes){
        this.ladder = ladder;
        this.players = players;
        this.prizes = prizes;
    }

}
