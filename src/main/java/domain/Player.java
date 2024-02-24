package domain;

public class Player {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validateNameLength(name);

        this.name = name;
    }

    private void validateNameLength(String name) {
        int nameLength = name.trim().length();

        if (nameLength < MIN_NAME_LENGTH || nameLength > MAX_NAME_LENGTH) {
            String message = String.format("이름은 %d~%d자 사이여야 합니다.", MIN_NAME_LENGTH, MAX_NAME_LENGTH);

            throw new IllegalArgumentException(message);
        }
    }

    public String getName() {
        return this.name;
    }
}
