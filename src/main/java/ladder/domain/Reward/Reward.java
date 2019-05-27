package ladder.domain.Reward;

public class Reward {
    private final String rewardName;
    private final int MAX_NAME_LENGTH = 5;

    public Reward(final String name) {
        validateNameLength(name);
        this.rewardName = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름이 " + MAX_NAME_LENGTH + "글자가 넘어갑니다.");
        }
    }

    @Override
    public String toString() {
        return rewardName;
    }

}
