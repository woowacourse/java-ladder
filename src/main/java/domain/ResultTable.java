package domain;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultTable {
    private final Map<User, Reward> resultTable = new LinkedHashMap<>();

    public void initialize(User user) {
        resultTable.put(user, null);
    }

    public Reward getRewardByUser(User user) {
        return resultTable.get(user);
    }

    public void save(User user, Reward resultReward) {
        resultTable.put(user, resultReward);
    }

    public List<User> getUsersWithoutReward() {
        return resultTable.keySet()
                .stream()
                .filter(this::isUnsaved)
                .collect(Collectors.toUnmodifiableList());
    }

    private boolean isUnsaved(User key) {
        return resultTable.get(key) == null;
    }

    public void saveAll(List<User> users, List<Reward> rewards) {
        for (int i = 0; i < users.size(); i++) {
            resultTable.put(users.get(i), rewards.get(i));
        }
    }

    public List<User> getUsers() {
        return resultTable.keySet()
                .stream()
                .collect(Collectors.toUnmodifiableList());
    }
}
