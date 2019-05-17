package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {
    private static String NIL = "꽝";

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
        ladder = new Ladder(names.size(), height, new Coin());
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