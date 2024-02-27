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
        if (name == null) {
            throw new IllegalArgumentException("이름은 null일 수 없다.");
        }
        if (name.isEmpty() || name.isBlank() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 한글자 이상 다섯글자 이하로 입력해야합니다.");
        }
        if (name.equals("all")) {
            throw new IllegalArgumentException("\"all\"이라는 이름은 입력할 수 없다.");
        }
    }

    public String getName() {
        return name;
    }

    public boolean hasEquivalentName(String name) {
        return name.equals(this.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
