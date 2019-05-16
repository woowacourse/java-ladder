package ladder.domain;

public class PlayerResult {
    private final String name;
    private final String reward;


    public PlayerResult(String name, String reward) {
        this.name = name;
        this.reward = reward;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != PlayerResult.class) {
            return false;
        }

        PlayerResult another = (PlayerResult) obj;
        return (this.name.equals(another.name) && this.reward.equals(another.reward));
    }
}
