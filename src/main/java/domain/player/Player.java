package domain.player;

import java.util.Objects;

public class Player {

    private static final int NAME_LENGTH_LOWER_BOUND = 1;
    private static final int NAME_LENGTH_UPPER_BOUND = 5;
    private static final int POSITION_LOWER_BOUND = 0;
    private static final String INVALID_NAME_LENGTH_ERROR_MESSAGE = "사람 이름은 1글자에서 5글자 사이이어야 합니다.";
    private static final String INVALID_POSITION_ERROR_MESSAGE = "사람의 위치는 자연수여야합니다.";

    private final String name;

    private int position;

    public Player(String name, int position) {
        String trimmedName = name.trim();
        validate(trimmedName, position);
        this.name = trimmedName;
        this.position = position;
    }

    public static Player from(String name) {
        return new Player(name, 0);
    }

    private static void validate(String name, int position) {
        validateName(name);
        validatePosition(position);
    }

    private static void validateName(String name) {
        if (isInvalidNameLength(name)) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private static boolean isInvalidNameLength(String name) {
        int length = name.length();
        return length < NAME_LENGTH_LOWER_BOUND || length > NAME_LENGTH_UPPER_BOUND;
    }

    private static void validatePosition(int position) {
        if (isInvalidPosition(position)) {
            throw new IllegalArgumentException(INVALID_POSITION_ERROR_MESSAGE);
        }
    }

    private static boolean isInvalidPosition(int position) {
        return position < POSITION_LOWER_BOUND;
    }

    public void move(MoveType moveType) {
        int step = moveType.getStep();
        validatePosition(position + step);
        position += step;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return name.equals(player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
