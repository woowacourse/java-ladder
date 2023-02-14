package domain;

public class PlayerName {

    private final String name;

    public PlayerName(final String name) {
        validateLengthOfName(name);
        this.name = name;
    }

    // TODO: 예외 메시지 작성
    private void validateLengthOfName(final String value) {
        if (value.length() < 1 || value.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }
}
