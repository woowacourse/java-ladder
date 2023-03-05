package domain;

import java.util.Objects;

public class PlayerName {

    private static final int PLAYER_NAME_MAX_LENGTH = 5;
    private static final String NOT_ALLOWED_NAME = "all";

    private final String name;

    public PlayerName(final String name) {
        validate(name);
        this.name = name;
    }

    public static void validate(final String name) {
        validateNotBlank(name);
        validateNameLength(name);
        validateNotAll(name);
    }

    private static void validateNotBlank(final String name) {
        if (Objects.isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("참여자 이름은 공백일 수 없습니다.");
        }
    }

    private static void validateNameLength(final String name) {
        if (name.length() > PLAYER_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("참여자 이름은 최대 5글자까지 가능합니다.");
        }
    }

    private static void validateNotAll(String name) {
        if (name.equals(NOT_ALLOWED_NAME)) {
            throw new IllegalArgumentException("참여자 이름은 all일 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }

}
