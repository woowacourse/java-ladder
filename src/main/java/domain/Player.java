package domain;

public class Player {
    public static final String NAME_LENGTH_ERROR_MESSAGE = "[ERROR] 플레이어의 이름은 최대 5글자까지입니다.";
    public static final int NAME_MAX_LENGTH = 5;
    private String name;

    public Player(String name) {
        this.name = validateName(name);
    }

    private String validateName(String name) {
        if (name.length() > NAME_MAX_LENGTH) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }

        return name;
    }
}
