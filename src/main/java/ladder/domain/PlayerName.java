package ladder.domain;

public class PlayerName {
    private static final int NAME_LENGTH_LOWER_BOUND_INCLUSIVE = 1;
    private static final int NAME_LENGTH_UPPER_BOUND_INCLUSIVE = 5;
    private static final String NOT_ALLOWED = " ";
    private static final String NAME_LENGTH_ERROR_MESSAGE = "플레이어 이름 길이는 1이상 5이하여야합니다.";
    private static final String NAME_FORMAT_ERROR_MESSAGE = "플레이어 이름에는 공백이 포함될 수 없습니다.";

    private final String name;

    public PlayerName(String name) {
        validateLength(name);
        validateBlank(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() < NAME_LENGTH_LOWER_BOUND_INCLUSIVE || name.length() > NAME_LENGTH_UPPER_BOUND_INCLUSIVE) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private void validateBlank(String name) {
        if (name.contains(NOT_ALLOWED)) {
            throw new IllegalArgumentException(NAME_FORMAT_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
