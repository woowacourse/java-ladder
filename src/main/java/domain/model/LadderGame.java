package domain.model;

import domain.vo.Result;

import java.util.List;

public class LadderGame {

    private final Ladder ladder;
    private final List<Player> players;
    private final List<Result> results;


    public LadderGame(Ladder ladder, List<Player> players, List<Result> results) {
        this.ladder = ladder;
        this.players = players;
        this.results = results;
    }

    public void play() {
        for (int i = 0; i < ladder.getHeight().getValue(); i++) {
            moveAllPlayers();
        }
    }

    private void moveAllPlayers() {
        for (Player player : players) {
            System.out.println(player.getName().getValue() + player.getXPosition() + ", " + player.getYPosition());
            player.move(ladder);
        }
    }


}
