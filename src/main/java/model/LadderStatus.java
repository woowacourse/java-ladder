package model;

public enum LadderStatus {

    CONNECTED(true, "-".repeat(5)),
    UNCONNECTED(false, " ".repeat(5)),
    ;

    private final boolean connectionInfo;
    private final String ladderForm;

    LadderStatus(final boolean connectionInfo, final String ladderForm) {
        this.connectionInfo = connectionInfo;
        this.ladderForm = ladderForm;
    }

    public static LadderStatus from(boolean isConnected) {
        if (isConnected) {
            return CONNECTED;
        }
        return UNCONNECTED;
    }

    public boolean isConnected() {
        return this.connectionInfo;
    }

    public String getLadderForm() {
        return ladderForm;
    }
}
