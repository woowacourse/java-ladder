package ladder.domain;

public class PlayerResult {


    private final String name;
    private final String reward;

    public PlayerResult(final String name, final String reward) {
        this.name = name;
        this.reward = reward;
    }

    public String reward() {
        return this.reward;
    }

    public String name() {
        return this.name;
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
