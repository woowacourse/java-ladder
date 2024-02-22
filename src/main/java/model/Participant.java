package model;

import java.util.Objects;

public class Participant {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Participant(String name) {
        validator(name);
        this.name = name;
    }

    private void validator(String name) {
        Objects.requireNonNull(name, "이름은 null일 수 없다.");

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 다섯글자까지 입력 가능하다.");
        }
        if (name.isEmpty() || name.isBlank()) {
            throw new IllegalArgumentException("이름은 한글자 이상 입력해야합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
