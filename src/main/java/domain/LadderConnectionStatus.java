package domain;

public enum LadderConnectionStatus {
    CONNECTION("-----"),
    NON_CONNECTION("     ");

    private final String status;

    LadderConnectionStatus(String status) {
        this.status = status;
    }

    public static String getConnectionStatus(Boolean point) {
        if (point) {
            return CONNECTION.status;
        }
        return NON_CONNECTION.status;
    }
}
