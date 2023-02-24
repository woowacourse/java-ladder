package ladder.domain;

public enum ResultCommand {
    END,
    ALL,
    PLAYER;

    private String name;

    public static ResultCommand from(String value) {
        if (value.equals("end")) {
            return END;
        }
        if (value.equals("all")) {
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
