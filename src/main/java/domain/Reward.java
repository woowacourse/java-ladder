package domain;

public class Reward {
    private final RewardName name;

    public Reward(String name) {
        name = name.trim();
        validateName(name);
        this.name = new RewardName(name);
    }

    private void validateName(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("결과는 공백일 수 없습니다.");
        }
    }

    public RewardName getName() {
        return name;
    }
}
