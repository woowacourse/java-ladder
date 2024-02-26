package view;

public enum LadderComponent {
    DIVISION("|"),
    LINE("-----"),
    EMPTY_LINE("     "),
    ;

    private final String output;

    LadderComponent(String output) {
        this.output = output;
    }

    public static LadderComponent match(boolean isLine) {
        if (isLine) {
            return LINE;
        }
        return EMPTY_LINE;
    }

    @Override
    public String toString() {
        return output;
    }
}
