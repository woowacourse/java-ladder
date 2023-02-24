package ladder.controller;

public enum GameCommand {
    PLAY(""),
    END("all");

    private final String command;

    GameCommand(String command) {
        this.command = command;
    }

    public static GameCommand of(String name) {
        if (END.command.equals(name)) {
            return END;
        }
        return PLAY;
    }

    public boolean isPlay() {
        return this == PLAY;
    }

    public boolean isEnd() {
        return this == END;
    }
}
