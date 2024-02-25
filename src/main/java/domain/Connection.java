package domain;

import strategy.ConnectionStrategy;

public enum Connection {

    CONNECTED,
    DISCONNECTED;

    Connection() {
    }

    public Connection makeNextConnection(ConnectionStrategy connectionStrategy) {
        if (this == CONNECTED) {
            return DISCONNECTED;
        }
        return connectionStrategy.generateConnection();
    }
}
