package utils.constants;

public enum GameRules {

    MIN_LADDER_HEIGHT(1),
    MAX_LADDER_HEIGHT(10),
    MAX_NAME_LENGTH(5);

    private final int value;

    GameRules(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
