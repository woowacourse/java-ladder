package domain;

public class Reward {
    private final String name;

    public Reward(String name) {
        name = name.trim();
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() == 0) {
            throw new IllegalArgumentException("결과는 공백일 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
