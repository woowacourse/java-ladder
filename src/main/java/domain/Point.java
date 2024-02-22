package domain;

public enum Point {

    CONNECTED(true, "-"),
    DISCONNECTED(false, " ");

    private final Boolean isConnected;
    private final String displayCharacter;

    Point(Boolean isConnected, String displayCharacter) {
        this.isConnected = isConnected;
        this.displayCharacter = displayCharacter;
    }

    public String getDisplayCharacter() {
        return displayCharacter;
    }
}
