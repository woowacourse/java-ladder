package ladder.domain;

public class Reward {
    private static final int MAX_NAME_LEN = 5;

    private final String name;

    public Reward(String name) {
        if (name == null || name.length() == 0) {
            throw new IllegalArgumentException("이름이 null 혹은 빈 문자열입니다.");
        }

        if (MAX_NAME_LEN < name.length()) {
            throw new IllegalArgumentException(
                    String.format("Reward.이름은 %d 글자보다 작아야 합니다. 현재길이: %d", MAX_NAME_LEN, name.length()));
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
