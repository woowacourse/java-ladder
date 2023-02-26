package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Results {

    private final List<Result> results;

    private Results(List<Result> results) {
        this.results = results;
    }

    public static Results from(List<Player> players, List<Reward> rewards) {
        List<Result> results = generateResults(players, rewards);
        return new Results(results);
    }

    private static List<Result> generateResults(List<Player> players, List<Reward> rewards) {
        return players.stream()
                .map(player -> toResult(player, rewards))
                .collect(Collectors.toList());
    }

    private static Result toResult(Player player, List<Reward> rewards) {
        Reward reward = rewards.get(player.getStandingLine());
        return new Result(player, reward);
    }

    public List<Result> getResults() {
        return List.copyOf(this.results);
    }

}
