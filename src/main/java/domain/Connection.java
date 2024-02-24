package domain;

import strategy.PointStrategy;

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

    public Connection makeNextConnection(PointStrategy pointStrategy) {
        if (this == CONNECTED) {
            return DISCONNECTED;
        }
        return pointStrategy.generatePoint();
    }
}
