package ladder.domain;

public enum ResultCommand {
    END,
    ALL,
    PLAYER;

    private static final String END_COMMAND = "end";
    private static final String ALL_COMMAND = "all";
    private String name;

    public static ResultCommand from(String value) {
        if (value.equals(END_COMMAND)) {
            return END;
        }
        if (value.equals(ALL_COMMAND)) {
            return ALL;
        }
        ResultCommand resultCommand = ResultCommand.PLAYER;
        resultCommand.setName(value);
        return resultCommand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
