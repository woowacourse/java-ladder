package domain.ladder;

import domain.Prizes;
import domain.player.Player;
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

    public void play() {
        for(Player player: players.getPlayers()){
            ladder.ride(player);
        }
    }
}
