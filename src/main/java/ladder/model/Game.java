package ladder.model;

import ladder.model.coin.Half;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Game {
    static String NIL = "꽝";

    private final List<Player> players = new ArrayList<>();
    private final Ladder ladder;

    public Game(List<String> names, List<String> rewards, int height) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException();
        }

        adjustInputs(names, rewards);
        for (int i = 0; i < names.size(); i++) { // Zip()이 있으면 좋을텐데…
            players.add(new Player(names.get(i), rewards.get(i)));
        }
        ladder = new Ladder(names.size(), height, new Half());
    }

    public Game(List<Player> players, int height) {
        this(
                getPlayersField(players, Player::getName),
                getPlayersField(players, Player::getReward),
                height
        );
    }

    private static List<String> getPlayersField(List<Player> players, Function<Player, String> mapper) {
        return players.stream().map(mapper).collect(Collectors.toList());
    } // 이 코드가 다른 곳에서도 반복해서 사용되는 것이 영 걸리는데…

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