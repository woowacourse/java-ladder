package domain;

import strategy.ConnectStrategy;

public enum Connection {

    CONNECTED, DISCONNECTED;

    public Connection findNextConnection(ConnectStrategy connectStrategy) {
        if (this.equals(Connection.CONNECTED)) {
            return Connection.DISCONNECTED;
        }
        return connectStrategy.generate();
    }
}
