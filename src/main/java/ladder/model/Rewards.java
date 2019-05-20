package ladder.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Rewards {
    public static String NIL = "꽝";

    private final List<String> rewards;

    public Rewards(Players players, List<String> rewardNames) {
        List<String> validated = rewardNames.stream()
                                            .map(String::trim)
                                            .filter(x -> x.length() > 0)
                                            .collect(Collectors.toList());
        rewards = Collections.unmodifiableList(
                IntStream.range(0, players.number()).boxed()
                        .map(i -> (i < validated.size()) ? validated.get(i) : NIL)
                        .collect(Collectors.toList())
        );
    }

    public int getLongestRewardNameLength() {
        return rewards.stream()
                        .mapToInt(String::length)
                        .max()
                        .getAsInt();
    }

    public List<String> getListOfRewards() {
        return rewards;
    }

    public String get(int index) {
        return rewards.get(index);
    }

    public int number() {
        return rewards.size();
    }

    @Override
    public String toString() {
        String temp = rewards.toString();
        return temp.substring(1, temp.length() - 1);
    }

}