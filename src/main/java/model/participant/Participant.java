package model.participant;

import java.util.Objects;

public class Participant {
    protected static final String NOT_ALLOWED_NULL_EMPTY_NAME = "참가자의 이름이 없거나 공백으로만 이루어져 있습니다.";
    protected static final String NOT_ALLOWED_OVER_LENGTH_NAME = "참여자의 이름은 최대 5글자입니다. 예: tobi";

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Participant(String name) {
        validateNameNullAndBlank(name);
        validateNameLength(name);
        this.name = name;
    }

    private static void validateNameNullAndBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(NOT_ALLOWED_NULL_EMPTY_NAME);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(NOT_ALLOWED_OVER_LENGTH_NAME);
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participant that = (Participant) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
