package laddergame.view;

public enum LadderElement {
    VERTICAL_POLE("|"),
    CONNECTED_HORIZONTAL_POLE("-----"),
    NOT_CONNECTED_HORIZONTAL_POLE("     ");

    private final String text;

    LadderElement(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
