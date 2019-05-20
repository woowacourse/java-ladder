package ladder.model;

public class Player {
    private static final int NAME_MIN_LENGTH = 1;
    private static final int NAME_MAX_LENGTH = 5;

    private final String name;
    private String reward;

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