package utils.constants;

public enum LadderFormat {
    START_DELIMITER("    |"),
    DELIMITER("|"),
    EXISTED_LINE("-----"),
    NON_EXISTED_LINE("     ");

    private final String format;

    LadderFormat(String format) {
        this.format = format;
    }

    public String getFormat() {
        return format;
    }
}
