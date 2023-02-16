package domain;

public class PlayerName {

    private static final int MINIMUM_LENGTH_OF_NAME = 1;
    private static final int MAXIMUM_LENGTH_OF_NAME = 5;

    private final String name;

    public PlayerName(final String name) {
        validateLengthOfName(name);
        this.name = name;
    }

    private void validateLengthOfName(final String name) {
        if (isNotPermittedLengthOfName(name)) {
            throw new IllegalArgumentException("이름의 길이는 최소 1자 이상, 5자 이하입니다.");
        }
    }

    private boolean isNotPermittedLengthOfName(final String name) {
        return (name.length() < MINIMUM_LENGTH_OF_NAME) || (name.length() > MAXIMUM_LENGTH_OF_NAME);
    }

    public String getName() {
        return this.name;
    }
}
