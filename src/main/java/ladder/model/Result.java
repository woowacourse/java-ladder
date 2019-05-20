package ladder.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Result implements Iterator {
    private final Players players;
    private final Rewards rewards;
    private final List<Integer> result;
    private int index = 0;

    Result(Players players, Rewards rewards, Ladder ladder, List<String> query) {
        this.players = players;
        this.rewards = ladder.apply(players, rewards);
        this.result = Collections.unmodifiableList(
                IntStream.range(0, players.number()).boxed()
                .filter(i -> query.contains("all") || query.contains(players.get(i)))
                .collect(Collectors.toList())
        );
    }
    public boolean hasNext() {
        return index < result.size();
    }

    public String next() {
        return players.get(result.get(index)) + " : " + rewards.get(result.get(index++));
    }
}