package util;


public enum LadderPrintMessage {
    START_LADDER("   |"),
    CONNECT_LADDER("-----|"),
    NO_CONNECT_LADDER("     |");

    private final String message;

    LadderPrintMessage(String move) {
        this.message = move;
    }

    public String getMessage() {
        return message;
    }
}
