package ladder.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Player {
    static final int NAME_MIN_LENGTH = 1;
    static final int NAME_MAX_LENGTH = 5;
    public static String NIL = "꽝";

    private final String name;
    private String reward;

    public static List<Player> init(List<String> names, List<String> rewards) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException();
        }
        while (names.size() > rewards.size()) {
            rewards.add(NIL);
        }
        return IntStream.range(0, names.size()).boxed()
            .map(i -> new Player(names.get(i), rewards.get(i)))
            .collect(Collectors.toList());
    }

    public Player(String name, String reward) {
        name = name.trim();
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException();
        }
        this.name = name;
        this.reward = reward.trim();
    }

    public String getName() {
        return name;
    }

    public String getReward() {
        return reward;
    }

    @Override
    public String toString() {
        return name + " : " + reward;
    }
}