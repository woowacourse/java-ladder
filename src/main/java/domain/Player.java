package domain;

public class Player {

    private static final int NAME_LENGTH_LOWER_BOUND = 1;
    private static final int NAME_LENGTH_UPPER_BOUND = 5;
    private static final int POSITION_LOWER_BOUND = 0;
    private static final int STEP_LOWER_BOUND = -1;
    private static final int STEP_UPPER_BOUND = 1;
    private static final String INVALID_NAME_LENGTH_ERROR_MESSAGE = "사람 이름은 1글자에서 5글자 사이이어야 합니다.";
    private static final String INVALID_POSITION_ERROR_MESSAGE = "사람의 위치는 자연수여야합니다.";
    private static final String INVALID_MOVE_ERROR_MESSAGE = "사람의 위치는 두 칸 이상 움직일 수 없습니다.";

    private final String name;

    private int position;

    public Player(String name, int position) {
        String trimmedName = name.trim();
        validate(trimmedName, position);
        this.name = trimmedName;
        this.position = position;
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

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move(int step) {
        validateMove(step);
        validatePosition(position + step);
        position = position + step;
    }

    private static void validateMove(int step) {
        if (isInvalidMoveStep(step)) {
            throw new IllegalArgumentException(INVALID_MOVE_ERROR_MESSAGE);
        }
    }

    private static boolean isInvalidMoveStep(int step) {
        return STEP_LOWER_BOUND > step || step > STEP_UPPER_BOUND;
    }
}
