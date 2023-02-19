package domain;

public enum LadderFormat {
    LADDER_COLUMN("|"),
    CONNECTION("-----"),
    NON_CONNECTION("     ");

    private final String format;

    LadderFormat(String format) {
        this.format = format;
    }

    public static String getConnectionStatus(Boolean point) {
        if (point) {
            return CONNECTION.format;
        }
        return NON_CONNECTION.format;
    }

    public String getFormat() {
        return format;
    }
}
