package domain;

public class Player {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final String INVALID_NAME_LENGTH_MESSAGE = "이름은 " + MIN_NAME_LENGTH + "글자 이상, " + MAX_NAME_LENGTH + "글자 이하이어야 합니다.";

    private final String name;
    private int position;

    public Player(String name, int position) {
        validateName(name);
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    private void validateName(String name) {
        if (name.length() < 1 || 5 < name.length()) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH_MESSAGE);
        }
    }

}
