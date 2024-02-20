package ladder;

public class PlayerName {

    public PlayerName(String name) {
        validate(name);
    }

    private static void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 한글자 이상이어야 합니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자를 넘을 수 없습니다.");
        }
    }
}
