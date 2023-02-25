package domain;

public class Player {

    private static final String NAME_LENGTH_MESSAGE = "이름은 1글자 이상, 5글자 이하여야 합니다.";

    private final String name;

    public Player(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateName(String name) {
        if (name.length() < 1 || 5 < name.length()) {
            throw new IllegalArgumentException(NAME_LENGTH_MESSAGE);
        }
    }

}
