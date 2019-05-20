package ladder.model;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Result implements Iterator {
    private final List<String> players;
    private final List<String> rewards;
    private int index = 0;

    Result(Players players, Rewards rewards, Ladder ladder, List<String> query) {
        final Rewards applied = ladder.apply(players, rewards);
        if (query.contains("all")) {
            this.players = Collections.unmodifiableList(players.getListOfPlayers());
            this.rewards = Collections.unmodifiableList(applied.getListOfRewards());
            return;
        }
        List<Integer> searchResult = IntStream.range(0, players.number()).boxed()
                                            .filter(i -> query.contains(players.get(i)))
                                            .collect(Collectors.toList());
        this.players = Collections.unmodifiableList(
                searchResult.stream()
                            .map(i -> players.get(i))
                            .collect(Collectors.toList())
        );
        this.rewards = Collections.unmodifiableList(
                searchResult.stream()
                            .map(i -> applied.get(i))
                            .collect(Collectors.toList())
        );
    }
    public boolean hasNext() {
        return index < players.size();
    }

    public String next() {
        return players.get(index) + " : " + rewards.get(index++);
    }
}