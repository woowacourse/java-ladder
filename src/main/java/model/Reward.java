package model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Reward {
    private final Map<Integer, String> rewards;

    public Reward(List<String> rewards) {
        this.rewards = new LinkedHashMap<>();
        for (int i = 0; i < rewards.size(); i++) {
            this.rewards.put(i, rewards.get(i));
        }
    }

    public boolean valueOf(int i) {
        return true;
    }
}
