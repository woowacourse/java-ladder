package laddergame.view;

public enum LadderUnit {
    LADDER_ROW_RUNG("-----"),
    LADDER_ROW_EMPTY("     "),
    LADDER_COL("|");

    private final String displayUnit;

    LadderUnit(String unit) {
        this.displayUnit = unit;
    }

    public String getDisplayUnit() {
        return displayUnit;
    }
}
