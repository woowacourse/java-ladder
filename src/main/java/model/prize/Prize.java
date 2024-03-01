package model.prize;

public class Prize {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String INVALID_NAME_LENGTH = "실행 결과는 최대 5글자입니다.";

    private final String name;

    public Prize(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }
}
