package domain;

public enum Point {

    CONNECTED( "-"),
    DISCONNECTED( " ");

    private final String displayCharacter;

    Point(String displayCharacter) {
        this.displayCharacter = displayCharacter;
    }

    public String getDisplayCharacter() {
        return displayCharacter;
    }
}
