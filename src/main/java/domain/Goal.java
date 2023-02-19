package domain;

public class Goal {
    public static final String MIN_LENGTH_ERROR_MESSAGE = "최소 한 글자 이상 작성해주세요.";
    public static final String MAX_LENGTH_ERROR_MESSAGE = "최대 다섯 글자 이하로 작성해주세요.";
    public static final int MIN_LENGTH = 1;
    public static final int MAX_LENGTH = 5;
    private final String name;

    private Goal(String name) {
        this.name = name;
    }

    public static Goal of(String name) {
        validateName(name);
        return new Goal(name);
    }

    private static void validateName(String name) {
        if (name.length() < MIN_LENGTH) {
            throw new IllegalArgumentException(MIN_LENGTH_ERROR_MESSAGE);
        }

        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(MAX_LENGTH_ERROR_MESSAGE);
        }
    }
}
