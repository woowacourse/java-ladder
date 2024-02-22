package view;

public enum LadderComponents {

    BRIDGE("-----"),
    NO_BRIDGE("     "),

    COLUMN("|"),
    FIRST_COLUMN("    |");

    private final String viewName;

    LadderComponents(final String viewName) {
        this.viewName = viewName;
    }

    public static LadderComponents getComponent(final boolean bridge) {
        if (bridge) {
            return BRIDGE;
        }
        return NO_BRIDGE;
    }

    public String getViewName() {
        return viewName;
    }
}
