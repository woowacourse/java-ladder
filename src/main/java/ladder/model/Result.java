package ladder.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Result implements Iterator {
    private final Players players;
    private final Rewards rewards;
    private final Queue<Integer> result;

    Result(Players players, Rewards rewards, Ladder ladder, List<String> query) {
        this.players = players;
        this.rewards = ladder.apply(players, rewards);
        this.result = IntStream.range(0, players.number()).boxed()
                        .filter(i -> query.contains("all") || query.contains(players.get(i)))
                        .collect(Collectors.toCollection(LinkedList::new));
    }
    public boolean hasNext() {
        return !result.isEmpty();
    }

    public String next() {
        final int index = result.poll();
        return players.get(index) + " : " + rewards.get(index);
    }
}