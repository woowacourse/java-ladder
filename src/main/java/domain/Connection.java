package domain;

public enum Connection {

    CONNECTED( "-"),
    DISCONNECTED( " ");

    private final String displayCharacter;

    Connection(String displayCharacter) {
        this.displayCharacter = displayCharacter;
    }

    public String getDisplayCharacter() {
        return displayCharacter;
    }
}
