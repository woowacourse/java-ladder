package ladder.model;

import ladder.model.Coin.Half;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    public static String NIL = "꽝";

    private final List<Player> players;
    private final Ladder ladder;

    public Game(List<String> names, List<String> rewards, int height) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException();
        }
        adjustInputs(names, rewards);
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            players.add(new Player(names.get(i), rewards.get(i)));
        }
        this.players = Collections.unmodifiableList(players);
        ladder = new Ladder(names.size(), height, new Half());
    }

    public Game(List<Player> players, int height) {
        this(
            players.stream().map(x -> x.getName()).collect(Collectors.toList()),
            players.stream().map(x -> x.getReward()).collect(Collectors.toList()),
            height
        );
    }

    private static void adjustInputs(List<String> names, List<String> rewards) {
        while (names.size() > rewards.size()) {
            rewards.add(NIL);
        }
        while (names.size() < rewards.size()) {
            rewards.remove(0);
        }
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