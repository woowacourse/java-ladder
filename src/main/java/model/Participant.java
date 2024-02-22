package model;

public class Participant {
    private static final String NULL_EMPTY_NAME = "참가자의 이름은 null 이거나 공백일 수 없습니다.";
    private static final String OVER_LENGTH_NAME = "참여자의 이름은 최대 5글자입니다.";

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Participant(String name) {
        validateNameNullAndBlank(name);
        validateNameLength(name);
        this.name = name;
    }

    private static void validateNameNullAndBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(NULL_EMPTY_NAME);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(OVER_LENGTH_NAME);
        }
    }

    public String getName() {
        return name;
    }
}
