package model.game;

import java.util.LinkedHashMap;
import model.ladder.Ladder;
import model.player.Player;
import model.player.Players;
import model.prize.Prize;
import model.prize.Prizes;

public class Game {
    private final Players players;
    private final Ladder ladder;
    private final Prizes prizes;

    public Game(final Players players, final Ladder ladder, final Prizes prizes) {
        this.players = players;
        this.ladder = ladder;
        this.prizes = prizes;
    }

    public GameResult play() {
        LinkedHashMap<Player, Prize> result = new LinkedHashMap<>();
        for (int index = 0; index < players.getSize(); index++) {
            Player player = players.get(index);
            int resultIndex = ladder.play(index);
            Prize prize = prizes.get(resultIndex);
            result.put(player, prize);
        }
        return new GameResult(result);
    }
}
