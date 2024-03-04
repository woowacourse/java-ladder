package common;

public enum Command {
    FINISH("all");

    private final String value;

    Command(final String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
