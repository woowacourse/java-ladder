package ladder.domain;

public class Player {
    public static final int MAX_NAME_LEN = 5;
    private final String name;

    private Player(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름이 null 혹은 비어있습니다.");
        }
        if (MAX_NAME_LEN < name.length()) {
            throw new IllegalArgumentException("이름은 " + MAX_NAME_LEN + " 자 이하여야 합니다.");
        }
        this.name = name;
    }

    public static Player from(String name) {
        return new Player(name);
    }

    public String getName() {
        return name;
    }
}
