package ladder.model;

import ladder.model.Coin.Half;

import java.util.Collections;
import java.util.List;

public class Game {
    private final List<Player> players;
    private final Ladder ladder;


    public Game(List<Player> players, int height) {
        this.players = Collections.unmodifiableList(players);
        ladder = new Ladder(players.size(), height, new Half());
    }

    public Game(List<String> names, List<String> rewards, int height) {
        this(Player.init(names, rewards), height);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Result getResultOf(List<String> query) {
        return new Result(players, ladder, query);
    }
}