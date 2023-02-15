package domain.model;

public class Name {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private static final String LENGTH_ERROR_MESSAGE = "이름 길이는 %d ~ %d 사이여야 합니다.";
    private final String name;

    public Name(final String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(final String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format(LENGTH_ERROR_MESSAGE, MIN_LENGTH, MAX_LENGTH));
        }
    }
}
