package view;

import model.Space;

public enum LadderComponent {
    DIVISION("|"),
    LINE("-----"),
    EMPTY_LINE("     "),
    ;

    private final String output;

    LadderComponent(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }

    public static LadderComponent match(Space space) {
        if (space.isValue()) {
            return LINE;
        }
        return EMPTY_LINE;
    }
}
