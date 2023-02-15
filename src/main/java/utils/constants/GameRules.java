package utils.constants;

public enum GameRules {
    MAX_NAME_LENGTH(5);

    private final int value;

    GameRules(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
