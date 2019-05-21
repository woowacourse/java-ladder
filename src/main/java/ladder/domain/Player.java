package ladder.domain;

import java.util.Objects;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    private final String name;

    public Player(final String name) {
        checkName(name);

        this.name = name;
    }

    private void checkName(String name) {
        if (Objects.isNull(name)) {
            System.err.println("빈칸이 있습니다.");
            throw new IllegalArgumentException();
        }

        if (name.trim().length() > MAX_NAME_LENGTH || name.trim().length() < MIN_NAME_LENGTH) {
            System.err.println("이름은 1~5자만 가능합니다.");
            throw new IllegalArgumentException();
        }
    }

    boolean isEqualName(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }

}
