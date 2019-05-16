package ladder.model;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final List<Player> players;
    private final Ladder ladder;

    public Game(List<String> names, List<String> rewards, int height) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException();
        }
        players = Player.init(names, rewards);
        ladder = new Ladder(names.size(), height, new Coin());
    }

    public List<String> getNames() {
        return players.stream().map(x -> x.getName()).collect(Collectors.toList());
    }

    public List<String> getRewards() {
        return players.stream().map(x -> x.getReward()).collect(Collectors.toList());
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Result getResultOf(List<String> query) {
        return new Result(players, ladder, query);
    }
}