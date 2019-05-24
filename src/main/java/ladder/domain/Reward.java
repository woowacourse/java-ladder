package ladder.domain;

public class Reward {
    public static final int MAX_NAME_LEN = 5;
    private final String name;

    private Reward(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름이 null 혹은 비어있습니다.");
        }
        if (MAX_NAME_LEN < name.length()) {
            throw new IllegalArgumentException("이름은 " + MAX_NAME_LEN + " 자 이하여야 합니다.");
        }
        this.name = name;
    }

    public static Reward from(String name) {
        return new Reward(name);
    }
}
