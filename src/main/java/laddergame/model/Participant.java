package laddergame.model;

import java.util.Objects;

public class Participant {
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Participant(final String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name == null || name.isBlank()) {
            String message = "[ERROR] 참여자 이름은 null이거나 공백일 수 없습니다. 입력값:" + name;
            throw new IllegalArgumentException(message);
        }
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            String message = "[ERROR] 참여자 이름의 길이는 " + MAXIMUM_NAME_LENGTH + "자를 초과할 수 없습니다. 입력값:" + name;
            throw new IllegalArgumentException(message);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Participant participant = (Participant) obj;
        return this.name.equals(participant.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
