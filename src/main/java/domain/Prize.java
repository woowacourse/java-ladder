package domain;

public class Prize {
    private static final int MAX_LENGTH = 5;
    private static final String BLANK_NAME_MESSAGE = "빈 문자열 입니다.";
    private static final String INVALID_NAME_LENGTH_MESSAGE = "실행결과 길이는 %d자를 넘길 수 없습니다.";

    private final String name;

    public Prize(String name) {
        validateNameBlank(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(BLANK_NAME_MESSAGE);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    String.format(INVALID_NAME_LENGTH_MESSAGE, MAX_LENGTH));
        }
    }

    public String getName() {
        return name;
    }

}
