package ladder.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private static String NIL = "꽝";
    static final int NAME_MIN_LENGTH = 1;
    static final int NAME_MAX_LENGTH = 5;

    private final String name;
    private String reward;

    public static List<Player> init(List<String> names, List<String> rewards) {
        if (names.isEmpty() || rewards.isEmpty()) {
            throw new IllegalArgumentException();
        }
        adjustInputs(names, rewards);
        return Collections.unmodifiableList(new ArrayList<Player>() {{
            for (int i = 0; i < names.size(); i++) {
                add(new Player(names.get(i), rewards.get(i)));
            }
        }});
    }

    private static void adjustInputs(List<String> names, List<String> rewards) {
        while (names.size() > rewards.size()) {
            rewards.add(NIL);
        }
        while (names.size() < rewards.size()) {
            rewards.remove(0);
        }
    }

    public Player(String name, String reward) {
        name = name.trim();
        if (name.length() < NAME_MIN_LENGTH || name.length() > NAME_MAX_LENGTH || name.equals("") || name.equals(" ")) {
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
}