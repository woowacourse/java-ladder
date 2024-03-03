package domain;

import strategy.ConnectStrategy;

public enum Connection {

    CONNECTED, DISCONNECTED;

    public Connection findNextConnection(ConnectStrategy connectStrategy) {
        if (this == CONNECTED) {
            return DISCONNECTED;
        }
        return connectStrategy.generate();
    }
}
