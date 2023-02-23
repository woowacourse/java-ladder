package laddergame.view.message;

public enum LadderMessage {

    LADDER_FRAME("|"),
    LADDER_RUNG("-----"),
    LADDER_BLANK("     "),
    LADDER_PADDING(" ");

    private final String message;

    LadderMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
