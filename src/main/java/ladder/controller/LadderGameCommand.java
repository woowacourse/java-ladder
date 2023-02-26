package ladder.controller;

enum LadderGameCommand {
    MULTIPLE,
    SINGLE;

    private static final String MULTIPLE_RESULT_RESERVED_NAME = "all";

    public static LadderGameCommand from(final String name) {
        if (MULTIPLE_RESULT_RESERVED_NAME.equals(name)) {
            return MULTIPLE;
        }
        return SINGLE;
    }

    public boolean isContinued() {
        return this == SINGLE;
    }
}
